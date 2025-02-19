package com.example.megacitycabbackend.service;

import com.example.megacitycabbackend.dto.LoginDto;
import com.example.megacitycabbackend.dto.UserDTO;
import com.example.megacitycabbackend.model.UserModel;
import com.example.megacitycabbackend.repo.UserRepo;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    UserService(UserRepo userRepo ,ModelMapper modelMapper){
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Autowired
    AuthenticationManager authManager;


    @Autowired
    private JwtService jwtService;





    public ResponseEntity<?> saveUser(UserDTO userDTO) throws  Exception{

        UserModel user = modelMapper.map(userDTO , UserModel.class);
        UserModel userReturn = null;

        try{
            Optional<UserModel> user2 = Optional.ofNullable(userRepo.findByUsername(userDTO.getUsername()));
            if(user2.isPresent()){
                System.out.println("Username already Exit");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username Already Exit");
            }else{
                Optional<UserModel> user3 = userRepo.findUserByEmail((userDTO.getEmail()));
                if(user3.isPresent()){
                    System.out.println("User email A lready Exit");
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User email Already Exit");
                }else{
                    Optional<UserModel> user4 = userRepo.findUserByNic((userDTO.getNic()));
                    if(user4.isPresent()){
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nic is already Exit");
                    }else{
                        userReturn = userRepo.save(user);
                    }
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body( modelMapper.map(userReturn , UserDTO.class));



    }

    public String login(LoginDto loginDto){
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername() , loginDto.getPassword()));

        if(authentication.isAuthenticated()){
            UserModel user = userRepo.findByUsername(loginDto.getUsername());
            return jwtService.generateToken(loginDto.getUsername() , user.getRole());
        }

        return "Fail";
        //commit
    }







}

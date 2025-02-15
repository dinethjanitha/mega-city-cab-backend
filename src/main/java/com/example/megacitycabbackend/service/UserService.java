package com.example.megacitycabbackend.service;

import com.example.megacitycabbackend.dto.LoginDto;
import com.example.megacitycabbackend.dto.UserDTO;
import com.example.megacitycabbackend.model.UserModel;
import com.example.megacitycabbackend.repo.UserRepo;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

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

    public UserDTO saveUser(UserDTO userDTO) throws  Exception{

        UserModel user = modelMapper.map(userDTO , UserModel.class);
        UserModel userReturn = null;
        try{
            userReturn = userRepo.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return modelMapper.map(userReturn , UserDTO.class);
    }

    public String login(LoginDto loginDto){
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername() , loginDto.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(loginDto.getUsername());
        }

        return "Fail";
    }





}

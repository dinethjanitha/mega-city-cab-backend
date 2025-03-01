package com.example.megacitycabbackend.controller;

import com.example.megacitycabbackend.dto.LoginDto;
import com.example.megacitycabbackend.dto.UserDTO;
import com.example.megacitycabbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);

    @GetMapping("/test")
    public String testMapping(){
        return "";
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) throws Exception{
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        return userService.saveUser(userDTO);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/auth")
    public String login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/user")
    public ResponseEntity<?> deleteUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO)
    }

}

package com.example.megacitycabbackend.controller;

import com.example.megacitycabbackend.dto.LoginDto;
import com.example.megacitycabbackend.dto.UserDTO;
import com.example.megacitycabbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);

    @GetMapping("/test")
    public String testMapping(){
        return "";
    }

    @PostMapping("/user")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) throws Exception{
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        return userService.saveUser(userDTO);
    }

    @PostMapping("/auth")
    public String login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }
}

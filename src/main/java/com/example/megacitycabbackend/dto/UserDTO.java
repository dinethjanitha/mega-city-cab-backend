package com.example.megacitycabbackend.dto;


import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String nic;
    private String email;
    private String username;
    private String password;
    private String address;
    private String gender;
}

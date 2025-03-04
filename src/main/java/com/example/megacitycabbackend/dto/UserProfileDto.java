package com.example.megacitycabbackend.dto;

import lombok.Data;

@Data
public class UserProfileDto {
    private String id;
    private String name;
    private String nic;
    private String email;
    private String username;
    private String address;
    private String role;
    private String gender;
}

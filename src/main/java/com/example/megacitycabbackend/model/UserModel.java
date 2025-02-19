package com.example.megacitycabbackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UserModel {
    @Id
    private String id;
    private String name;
    private String nic;
    private String email;
    private String username;
    private String password;
    private String role;
    private String address;
    private String gender;

}

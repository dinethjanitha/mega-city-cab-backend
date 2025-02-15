package com.example.megacitycabbackend.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UserModel {
    private String id;
    private String nic;
    private String email;
    private String username;
    private String password;
    private String address;
    private String gender;

}

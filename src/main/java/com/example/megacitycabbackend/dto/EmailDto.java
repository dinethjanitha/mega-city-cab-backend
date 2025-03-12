package com.example.megacitycabbackend.dto;

import lombok.Data;

@Data
public class EmailDto {
    String email;
    String subject;
    String message;
}

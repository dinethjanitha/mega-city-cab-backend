package com.example.megacitycabbackend.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class CabDto {
    @Id
    private String id;
    @NotNull(message = "Cab name is required!")
    private String cabName;
    private String ownerName;
    private String ownerId;
    private String driverName;
    private String driverLicence;
    private String userId;
    private String cabDescription;
    private String imgUrl;
}

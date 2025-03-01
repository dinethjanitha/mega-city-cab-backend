package com.example.megacitycabbackend.model;

import com.mongodb.lang.NonNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Document
@Validated
public class CabModel {
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

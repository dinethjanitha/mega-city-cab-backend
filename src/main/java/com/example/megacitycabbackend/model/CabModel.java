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
    private String driveId;
    private String driverLicence;
    private String userId;
    private String cabDescription;
    private String phoneNumber;
    private String addedDate;
    private int sheetCount;
    private double first7kmPrice;
    private double avarageKmPrice;
    private String status;
    private String imgUrl;
}

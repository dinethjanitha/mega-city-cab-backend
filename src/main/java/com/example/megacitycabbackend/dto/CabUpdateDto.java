package com.example.megacitycabbackend.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class CabUpdateDto {
    private String id;
    private String cabName;
    private String ownerName;
    private String driverLicence;
    private String cabDescription;
    private String phoneNumber;
    private String addedDate;
    private int sheetCount;
    private double first7kmPrice;
    private double avarageKmPrice;
    private String status;
}

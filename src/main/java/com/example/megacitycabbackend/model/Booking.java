package com.example.megacitycabbackend.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Booking {
    @Id
    private String id;
    private String userId;
    private String cabId;
    private String driverId;
    private String bookingTime;
    private String bookingDate;
    private double totalKM;
    private double total;
    private String bookingStatus;
    private String note;
    private String startDestination;
    private String endDestination;
    private String date;
}

package com.example.megacitycabbackend.dto;

import lombok.Data;

@Data
public class BookingBillingDto {
    private String id;
    private double totalKM;
    private double total;
    private String bookingStatus;
}

package com.example.megacitycabbackend.dto;

import lombok.Data;

@Data
public class BookingDtoUsers {
    private String id;
    private String bookingTime;
    private String bookingDate;
    private String note;
    private String startDestination;
    private String endDestination;
    private String date;
}

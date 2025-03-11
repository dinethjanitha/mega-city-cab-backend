package com.example.megacitycabbackend.controller;

import com.example.megacitycabbackend.dto.BookingBillingDto;
import com.example.megacitycabbackend.dto.BookingDtoUsers;
import com.example.megacitycabbackend.dto.BookingStatusUpdateDto;
import com.example.megacitycabbackend.model.Booking;
import com.example.megacitycabbackend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<?> saveBooking(@RequestBody Booking booking){
        if(booking.getDriverId().isEmpty() || booking.getUserId().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Required field not found!");
        }

        return bookingService.makeBooking(booking);
    }

    @GetMapping("/bookings/driver/{id}")
    public ResponseEntity<?> getDriverBookings(@PathVariable String id){
        return bookingService.getDriverBookings(id);
    }


    @PatchMapping("/booking")
    public ResponseEntity<?> updateBooking(@RequestBody BookingStatusUpdateDto bookingStatusUpdateDto){
        return bookingService.updateBooking(bookingStatusUpdateDto);
    }

    @GetMapping("/booking/user/{id}")
    public ResponseEntity<?> getUserBookings(@PathVariable String id){
        return bookingService.getUserBookings(id);
    }

    @DeleteMapping("/booking/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable String id){
        return bookingService.deleteBooking(id);
    }

    @PatchMapping("/booking/user")
    public ResponseEntity<?> updateUserBooking(@RequestBody BookingDtoUsers bookingDtoUsers){
        return bookingService.updateBookingForUsers(bookingDtoUsers);
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<?> getBooking(@PathVariable String id){
        return bookingService.getOneBooking(id);
    }

    @PatchMapping("/booking/bill")
    public ResponseEntity<?> updateBookingBill(@RequestBody BookingBillingDto bookingBillingDto){
        return bookingService.updateBillingDetails(bookingBillingDto);
    }

    @GetMapping("/bookings/today/count")
    public long getTodayBookingCount() {
        return bookingService.getTodayBookingCount();
    }




}

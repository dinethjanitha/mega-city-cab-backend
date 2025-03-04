package com.example.megacitycabbackend.service;

import com.example.megacitycabbackend.dto.BookingDtoUsers;
import com.example.megacitycabbackend.dto.BookingUpdateDto;
import com.example.megacitycabbackend.model.Booking;
import com.example.megacitycabbackend.repo.BookingRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookingRepo bookingRepo;


    public ResponseEntity<?> makeBooking(Booking booking){

        Booking bookingDetails = bookingRepo.save(booking);

        if(bookingDetails != null && bookingDetails.getId() != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingDetails);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not placed!");

    }

    public ResponseEntity<?> updateBooking(BookingUpdateDto bookingUpdateDto){

        Optional<Booking> getBooking = bookingRepo.findById(bookingUpdateDto.getId());

        if(getBooking.isPresent()){
            getBooking.get().setBookingStatus(bookingUpdateDto.getBookingStatus());
            Booking bookingDetails = bookingRepo.save(getBooking.get());
            if(bookingDetails != null && bookingDetails.getId() != null){
                return ResponseEntity.status(HttpStatus.CREATED).body(bookingDetails);
            }
        }



        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not placed!");
    }


    public ResponseEntity<?> deleteBooking(String id){
        Optional<Booking> checkBooking = bookingRepo.findById(id);

        if(checkBooking.isPresent()){
            bookingRepo.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body("Booking Deleted!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found!");

    }


    public ResponseEntity<?> getBooking(String id){
        Optional<Booking> booking = bookingRepo.findById(id);

        if(booking.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(booking.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found!");
    }

    public ResponseEntity<?> getDriverBookings(String id){
        List<Booking> bookingDetails = bookingRepo.findAllByDriverId(id).stream().collect(Collectors.toList());

        if(bookingDetails.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bookings not found!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(bookingDetails);
    }


    public ResponseEntity<?> getUserBookings(String id){
//        List<Booking> bookinglist = ;
        return ResponseEntity.status(HttpStatus.OK).body(bookingRepo.findAllByUserId(id));
    }


    public ResponseEntity<?> updateBookingForUsers(BookingDtoUsers bookingDtoUsers){

        Optional<Booking> getBooking = bookingRepo.findById(bookingDtoUsers.getId());

        if(getBooking.isPresent()){
            getBooking.get().setStartDestination(bookingDtoUsers.getStartDestination());
            getBooking.get().setEndDestination(bookingDtoUsers.getEndDestination());
            getBooking.get().setBookingTime(bookingDtoUsers.getBookingTime());
            getBooking.get().setBookingDate(bookingDtoUsers.getBookingDate());
            getBooking.get().setNote(bookingDtoUsers.getNote());
            Booking bookingDetails = bookingRepo.save(getBooking.get());
            if(bookingDetails != null && bookingDetails.getId() != null){
                return ResponseEntity.status(HttpStatus.CREATED).body(bookingDetails);
            }
        }



        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not placed!");
    }
}

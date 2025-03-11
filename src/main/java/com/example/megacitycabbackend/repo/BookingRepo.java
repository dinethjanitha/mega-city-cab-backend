package com.example.megacitycabbackend.repo;

import com.example.megacitycabbackend.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepo extends MongoRepository<Booking , String> {
    List<Booking> findAllByDriverId(String driverId);

    Object findByUserId(String userId);

    List<Booking> findAllByUserId(String userId);

    List<Booking> findAllByUserIdAndBookingStatusNot(String userId, String bookingStatus);

    @Query("{ 'bookingDate' : { $regex: ?0 } }")
    Optional<Long> countByBookingDate(String bookingDate);
}

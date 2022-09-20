package com.hotel.reservationmanagement.repository;

import com.hotel.reservationmanagement.entity.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, String> {

    Reservation findByBookingID(String bookingID);

    Reservation deleteByBookingID(String bookingID);
}

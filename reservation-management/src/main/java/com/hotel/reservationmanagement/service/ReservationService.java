package com.hotel.reservationmanagement.service;

import com.hotel.reservationmanagement.entity.Reservation;

import java.util.List;

public interface ReservationService {

    public Reservation addReservation(Reservation reservation);

    public List<Reservation> getAllReservation();

    public Reservation getReservationByBookingID(String bookingID);

    public Reservation updateReservationByBookingID(String bookingID, Reservation newReservation);

    public void deleteReservationByBookingID(String bookingID);
}

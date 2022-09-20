package com.hotel.reservationmanagement.service.impl;

import com.hotel.reservationmanagement.entity.Reservation;
import com.hotel.reservationmanagement.repository.ReservationRepository;
import com.hotel.reservationmanagement.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationByBookingID(String bookingID) {
        return reservationRepository.findByBookingID(bookingID);
    }

    @Override
    public Reservation updateReservationByBookingID(String bookingID, Reservation newReservation) {
        Reservation oldReservation = reservationRepository.findByBookingID(bookingID);

        if (oldReservation != null) {
            if (newReservation.getMemberCode() > 0)
                oldReservation.setMemberCode(newReservation.getMemberCode());

            if (newReservation.getNoOfChildren() >= 0)
                oldReservation.setNoOfChildren(newReservation.getNoOfChildren());

            if (newReservation.getNoOfAdult() >= 0)
                oldReservation.setNoOfAdult(newReservation.getNoOfAdult());

            if (newReservation.getCheckInDate() != null && !newReservation.getCheckInDate().isEmpty())
                oldReservation.setCheckInDate(newReservation.getCheckInDate());

            if (newReservation.getCheckOutDate() != null && !newReservation.getCheckOutDate().isEmpty())
                oldReservation.setCheckOutDate(newReservation.getCheckOutDate());

            if (newReservation.getNoOfNights() > 0)
                oldReservation.setNoOfNights(newReservation.getNoOfNights());

            if (newReservation.getPaymentStatus() != null && !newReservation.getPaymentStatus().isEmpty())
                oldReservation.setPaymentStatus(newReservation.getPaymentStatus());

            return reservationRepository.save(oldReservation);
        } else
            return null;
    }

    @Override
    public void deleteReservationByBookingID(String bookingID) {
        reservationRepository.deleteByBookingID(bookingID);
    }
}

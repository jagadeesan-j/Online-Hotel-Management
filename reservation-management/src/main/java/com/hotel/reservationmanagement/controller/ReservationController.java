package com.hotel.reservationmanagement.controller;

import com.hotel.reservationmanagement.entity.Reservation;
import com.hotel.reservationmanagement.service.ReservationService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    Logger logger = LoggerFactory.getLogger(ReservationController.class);

    @GetMapping("/test")
    @ApiOperation(value = "Tests Reservation Controller.",
            notes = "This API returns a string if the controller is working fine.",
            response = String.class)
    public String test() {
        logger.debug("Reservation test endpoint called.");
        return "Testing reservation controller.";
    }

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        logger.debug("Add reservation endpoint called.");
        return reservationService.addReservation(reservation);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservation() {
        logger.debug("List all reservation endpoint called.");
        return reservationService.getAllReservation();
    }

    @GetMapping("/getByBookingID/{bookingID}")
    public Reservation getReservationByBookingID(@PathVariable("bookingID") String bookingID) {
        logger.debug("Get reservation by booking ID endpoint called.");
        return reservationService.getReservationByBookingID(bookingID);
    }

    @PutMapping("/updateByBookingID/{bookingID}")
    public Reservation updateReservationByBookingID(@RequestBody Reservation newReservation, @PathVariable("bookingID") String bookingID) {
        logger.debug("Update reservation by booking ID endpoint called.");
        return reservationService.updateReservationByBookingID(bookingID, newReservation);
    }

    @DeleteMapping("/deleteByBookingID/{bookingID}")
    public String deleteReservationByBookingID(@PathVariable("bookingID") String bookingID) {
        reservationService.deleteReservationByBookingID(bookingID);
        logger.debug("Delete reservation by booking ID endpoint called.");
        return "Deleted successfully.";
    }
}

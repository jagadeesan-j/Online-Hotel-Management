package com.hotel.guestmanagement.controller;

import com.hotel.guestmanagement.entity.Guest;
import com.hotel.guestmanagement.service.GuestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    Logger logger = LoggerFactory.getLogger(GuestController.class);

    @GetMapping("/test")
    public String test() {
        logger.debug("Guest test endpoint called.");
        return "Testing guest controller.";
    }

    @PostMapping("/add")
    public Guest addGuest(@RequestBody Guest guest) {
        logger.debug("Add guest endpoint called.");
        return guestService.addGuest(guest);
    }

    @GetMapping("/all")
    public List<Guest> getAllGuest() {
        logger.debug("List all guest endpoint called.");
        return guestService.getAllGuest();
    }

    @GetMapping("/getGuestByMemberCode/{memberCode}")
    public Guest getGuestByMemberCode(@PathVariable("memberCode") int memberCode) {
        logger.debug("Get guest by member code endpoint called.");
        return guestService.getGuestByMemberCode(memberCode);
    }

    @PutMapping("/update/{memberCode}")
    public Guest updateGuest(@RequestBody Guest newGuest, @PathVariable("memberCode") int memberCode) {
        logger.debug("Update guest by member code endpoint called.");
        return guestService.updateGuestByMemberCode(memberCode, newGuest);
    }

    @DeleteMapping("/deleteByMemberCode/{memberCode}")
    public String deleteGuestByMemberCode(@PathVariable("memberCode") int memberCode) {
        logger.debug("Delete guest by member code endpoint called.");
        guestService.deleteGuestByMemberCode(memberCode);
        return "Deleted successfully.";
    }
}

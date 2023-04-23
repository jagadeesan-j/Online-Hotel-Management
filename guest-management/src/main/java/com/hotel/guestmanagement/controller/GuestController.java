package com.hotel.guestmanagement.controller;

import com.hotel.guestmanagement.entity.Guest;
import com.hotel.guestmanagement.service.GuestService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    Logger logger = LoggerFactory.getLogger(GuestController.class);

    @GetMapping("/test")
    @ApiOperation(value = "Tests Guest Controller.",
            notes = "This API returns a string if the controller is working fine.",
            response = String.class)
    public String test() {
        logger.info("Guest test endpoint called.");
        return "Testing guest controller.";
    }

    @PostMapping("/add")
    public Guest addGuest(@Valid @RequestBody Guest guest) {
        logger.info("Add guest endpoint called.");
        return guestService.addGuest(guest);
    }

    @GetMapping("/all")
    public List<Guest> getAllGuest() {
        logger.info("List all guest endpoint called.");
        return guestService.getAllGuest();
    }

    @GetMapping("/getGuestByMemberCode/{memberCode}")
    public Guest getGuestByMemberCode(@PathVariable("memberCode") int memberCode) {
        logger.info("Get guest by member code endpoint called.");
        return guestService.getGuestByMemberCode(memberCode);
    }

    @PutMapping("/update/{memberCode}")
    public Guest updateGuest(@Valid @RequestBody Guest newGuest, @PathVariable("memberCode") int memberCode) {
        logger.info("Update guest by member code endpoint called.");
        return guestService.updateGuestByMemberCode(memberCode, newGuest);
    }

    @DeleteMapping("/deleteByMemberCode/{memberCode}")
    public String deleteGuestByMemberCode(@PathVariable("memberCode") int memberCode) {
        logger.info("Delete guest by member code endpoint called.");
        guestService.deleteGuestByMemberCode(memberCode);
        return "Deleted successfully.";
    }
}

package com.hotel.guestmanagement.controller;

import com.hotel.guestmanagement.entity.Guest;
import com.hotel.guestmanagement.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping("/test")
    public String test() {
        return "Testing guest controller.";
    }

    @PostMapping("/add")
    public Guest addGuest(@RequestBody Guest guest) {
        return guestService.addGuest(guest);
    }

    @GetMapping("/all")
    public List<Guest> getAllGuest() {
        return guestService.getAllGuest();
    }

    @GetMapping("/getGuestByMemberCode/{memberCode}")
    public Guest getGuestByMemberCode(@PathVariable("memberCode") int memberCode) {
        return guestService.getGuestByMemberCode(memberCode);
    }

    @PutMapping("/update/{memberCode}")
    public Guest updateGuest(@RequestBody Guest newGuest, @PathVariable("memberCode") int memberCode) {
        return guestService.updateGuestByMemberCode(memberCode, newGuest);
    }

    @DeleteMapping("/deleteByMemberCode/{memberCode}")
    public String deleteGuestByMemberCode(@PathVariable("memberCode") int memberCode) {
        guestService.deleteGuestByMemberCode(memberCode);
        return "Deleted successfully.";
    }
}

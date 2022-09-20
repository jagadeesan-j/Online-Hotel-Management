package com.hotel.reservationmanagement.controller;

import com.hotel.reservationmanagement.entity.Room;
import com.hotel.reservationmanagement.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    Logger logger = LoggerFactory.getLogger(RoomController.class);

    @GetMapping("/test")
    public String test() {
        logger.debug("Room test endpoint called.");
        return "Testing room controller.";
    }

    @PostMapping("/add")
    public Room addRoom(@RequestBody Room room) {
        logger.debug("Add room endpoint called.");
        return roomService.addRoom(room);
    }

    @GetMapping("/all")
    public List<Room> getAllRoom() {
        logger.debug("List all room endpoint called.");
        return roomService.getAllRoom();
    }

    @GetMapping("/getByRoomNumber/{roomNumber}")
    public Room getRoomByRoomNumber(@PathVariable("roomNumber") int roomNumber) {
        logger.debug("Get room by room number endpoint called.");
        return roomService.getRoomByRoomNumber(roomNumber);
    }

    @PutMapping("/updateByRoomNumber/{roomNumber}")
    public Room updateRoomByRoomNumber(@RequestBody Room newRoom, @PathVariable("roomNumber") int roomNumber) {
        logger.debug("Update room by room number endpoint called.");
        return roomService.updateRoomByRoomNumber(roomNumber, newRoom);
    }

    @DeleteMapping("/deleteByRoomNumber/{roomNumber}")
    public String deleteRoomByRoomNumber(@PathVariable("roomNumber") int roomNumber) {
        roomService.deleteRoomByRoomNumber(roomNumber);
        logger.debug("Delete room by room number endpoint called.");
        return "Deleted successfully.";
    }
}

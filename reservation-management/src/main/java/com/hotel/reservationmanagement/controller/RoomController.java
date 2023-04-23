package com.hotel.reservationmanagement.controller;

import com.hotel.reservationmanagement.entity.Room;
import com.hotel.reservationmanagement.service.RoomService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservation/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    Logger logger = LoggerFactory.getLogger(RoomController.class);

    @GetMapping("/test")
    @ApiOperation(value = "Tests Room Controller.",
            notes = "This API returns a string if the controller is working fine.",
            response = String.class)
    public String test() {
        logger.info("Room test endpoint called.");
        return "Testing room controller.";
    }

    @PostMapping("/add")
    public Room addRoom(@Valid @RequestBody Room room) {
        logger.info("Add room endpoint called.");
        return roomService.addRoom(room);
    }

    @GetMapping("/all")
    public List<Room> getAllRoom() {
        logger.info("List all room endpoint called.");
        return roomService.getAllRoom();
    }

    @GetMapping("/getByRoomNumber/{roomNumber}")
    public Room getRoomByRoomNumber(@PathVariable("roomNumber") int roomNumber) {
        logger.info("Get room by room number endpoint called.");
        return roomService.getRoomByRoomNumber(roomNumber);
    }

    @PutMapping("/updateByRoomNumber/{roomNumber}")
    public Room updateRoomByRoomNumber(@Valid @RequestBody Room newRoom, @PathVariable("roomNumber") int roomNumber) {
        logger.info("Update room by room number endpoint called.");
        return roomService.updateRoomByRoomNumber(roomNumber, newRoom);
    }

    @DeleteMapping("/deleteByRoomNumber/{roomNumber}")
    public String deleteRoomByRoomNumber(@PathVariable("roomNumber") int roomNumber) {
        roomService.deleteRoomByRoomNumber(roomNumber);
        logger.info("Delete room by room number endpoint called.");
        return "Deleted successfully.";
    }
}

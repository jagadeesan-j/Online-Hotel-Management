package com.hotel.reservationmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
public class Room {

    @Id
    private int roomNumber;

    @NotNull(message = "Room tier must be entered")
    private String roomTier;

    @NotNull(message = "Room type must be entered")
    private String roomType;

    @NotNull(message = "Room status is mandatory.")
    private String roomStatus;

    public Room() {
    }

    public Room(int roomNumber, String roomTier, String roomType, String roomStatus) {
        this.roomNumber = roomNumber;
        this.roomTier = roomTier;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomTier() {
        return roomTier;
    }

    public void setRoomTier(String roomTier) {
        this.roomTier = roomTier;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
}

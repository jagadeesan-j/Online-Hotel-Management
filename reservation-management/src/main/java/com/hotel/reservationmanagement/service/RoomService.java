package com.hotel.reservationmanagement.service;

import com.hotel.reservationmanagement.entity.Room;

import java.util.List;

public interface RoomService {

    public Room addRoom(Room room);

    public List<Room> getAllRoom();

    public Room getRoomByRoomNumber(int roomNumber);

    public Room updateRoomByRoomNumber(int roomNumber, Room newRoom);

    public void deleteRoomByRoomNumber(int roomNumber);
}

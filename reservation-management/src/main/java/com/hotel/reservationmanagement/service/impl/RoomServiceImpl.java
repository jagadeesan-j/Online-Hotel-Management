package com.hotel.reservationmanagement.service.impl;

import com.hotel.reservationmanagement.entity.Room;
import com.hotel.reservationmanagement.repository.RoomRepository;
import com.hotel.reservationmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomByRoomNumber(int roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    @Override
    public Room updateRoomByRoomNumber(int roomNumber, Room newRoom) {
        Room oldRoom = roomRepository.findByRoomNumber(roomNumber);

        if (oldRoom != null) {
            if (newRoom.getRoomTier() != null && !newRoom.getRoomTier().isEmpty())
                oldRoom.setRoomTier(newRoom.getRoomTier());

            if (newRoom.getRoomType() != null && !newRoom.getRoomType().isEmpty())
                oldRoom.setRoomType(newRoom.getRoomType());

            if (newRoom.getRoomStatus() != null && !newRoom.getRoomStatus().isEmpty())
                oldRoom.setRoomStatus(newRoom.getRoomStatus());

            return roomRepository.save(oldRoom);
        } else
            return null;
    }

    @Override
    public void deleteRoomByRoomNumber(int roomNumber) {
        roomRepository.deleteByRoomNumber(roomNumber);
    }
}

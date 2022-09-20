package com.hotel.reservationmanagement.repository;

import com.hotel.reservationmanagement.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, Integer> {

    Room findByRoomNumber(int roomNumber);

    Room deleteByRoomNumber(int roomNumber);
}

package com.hotel.guestmanagement.repository;

import com.hotel.guestmanagement.entity.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuestRepository extends MongoRepository<Guest, Integer> {

    Guest findByMemberCode(int memberCode);

    Guest deleteByMemberCode(int memberCode);
}

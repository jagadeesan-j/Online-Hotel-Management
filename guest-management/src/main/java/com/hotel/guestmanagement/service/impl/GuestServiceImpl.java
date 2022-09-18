package com.hotel.guestmanagement.service.impl;

import com.hotel.guestmanagement.entity.Guest;
import com.hotel.guestmanagement.repository.GuestRepository;
import com.hotel.guestmanagement.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public List<Guest> getAllGuest() {
        return guestRepository.findAll();
    }

    @Override
    public Guest getGuestByMemberCode(int memberCode) {
        return guestRepository.findByMemberCode(memberCode);
    }

    @Override
    public Guest updateGuestByMemberCode(int memberCode, Guest newGuest) {
        Guest oldGuest = guestRepository.findByMemberCode(memberCode);

        if(oldGuest != null) {
            if(newGuest.getName()!=null && !newGuest.getName().isEmpty())
                oldGuest.setName(oldGuest.getName());

            if(newGuest.getPhoneNumber() != 0)
                oldGuest.setPhoneNumber(newGuest.getPhoneNumber());

            if(newGuest.getCompany()!= null && !newGuest.getCompany().isEmpty())
                oldGuest.setCompany(newGuest.getCompany());

            if(newGuest.getEmail()!= null && !newGuest.getEmail().isEmpty())
                oldGuest.setEmail(newGuest.getEmail());

            if(newGuest.getGender()!= null && !newGuest.getGender().isEmpty())
                oldGuest.setGender(newGuest.getGender());

            if(newGuest.getAddress()!= null && !newGuest.getAddress().isEmpty())
                oldGuest.setAddress(newGuest.getAddress());

            return guestRepository.save(oldGuest);
        } else
            return null;
    }

    @Override
    public void deleteGuestByMemberCode(int memberCode) {
        guestRepository.deleteById(memberCode);
    }
}

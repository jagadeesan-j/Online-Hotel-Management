package com.hotel.guestmanagement.service;

import com.hotel.guestmanagement.entity.Guest;

import java.util.List;

public interface GuestService {

    public Guest addGuest(Guest guest);

    public List<Guest> getAllGuest();

    public Guest getGuestByMemberCode(int memberCode);

    public Guest updateGuestByMemberCode(int memberCode, Guest newGuest);

    public void deleteGuestByMemberCode(int memberCode);
}

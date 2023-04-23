package com.hotel.guestmanagement;

import com.hotel.guestmanagement.entity.Guest;
import com.hotel.guestmanagement.repository.GuestRepository;
import com.hotel.guestmanagement.service.GuestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class GuestManagementApplicationTests {

	@Autowired
	private GuestService guestService;

	@MockBean
	private GuestRepository guestRepository;

	@Test
	public void addGuestTest() {
		Guest guest = new Guest(101, 987654321, "ABC", "Member101",
				"member101@abc.com", "female", "Bangalore");
		guestRepository.save(guest);

		verify(guestRepository, times(1)).save(guest);
	}

	@Test
	public void getAllGuestTest() {
		when(guestRepository.findAll()).thenReturn(Stream.of(
				(new Guest(101, 987654321, "ABC", "Member101",
						"member101@abc.com", "female", "Bangalore")),
				(new Guest(102, 12345678, "XYZ", "Member102",
						"member102@xyz.com", "male", "Bangalore")))
				.collect(Collectors.toList()));

		assertEquals(2,guestService.getAllGuest().size());
	}

	@Test
	public void updateGuestByMemberCodeTest() {
		Guest guest = new Guest(101, 987654321, "ABC", "Member101",
				"member101@abc.com", "female", "Bangalore");
		guestRepository.findByMemberCode(101);
		guest.setName("Member 101");
		guestRepository.save(guest);

		assertThat(guest.getName()).isEqualTo("Member 101");
	}

	@Test
	public void deleteGuestByMemberCodeTest() {
		Guest guest = new Guest(101, 987654321, "ABC", "Member101",
				"member101@abc.com", "female", "Bangalore");
		guestRepository.deleteByMemberCode(1);

		assertEquals(0, guestService.getAllGuest().size());
	}
}

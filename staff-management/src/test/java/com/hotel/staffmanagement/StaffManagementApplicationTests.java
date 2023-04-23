package com.hotel.staffmanagement;

import com.hotel.staffmanagement.entity.Staff;
import com.hotel.staffmanagement.repository.StaffRepository;
import com.hotel.staffmanagement.service.StaffService;
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
class StaffManagementApplicationTests {

	@Autowired
	private StaffService staffService;

	@MockBean
	private StaffRepository staffRepository;

	@Test
	public void getRoomTest() {
		when(staffRepository.findAll()).thenReturn(Stream.of(
				new Staff("EMP101", "Employee 101", "Bangalore", "TYA7856FG",
						30000, 30, "Manager","pass", "emp101@hotel.com"),
				new Staff("EMP102", "Employee 102", "Mumbai", "HSO874JH",
						10000, 25, "Manager","pass", "emp102@hotel.com"))
				.collect(Collectors.toList()));

		assertEquals(staffRepository.findByEmployeeCode("EMP101"), staffService.getStaffByEmployeeCode("EMP101"));
	}

	@Test
	public void saveRoomTest() {
		Staff staff = new Staff("EMP101", "Employee 101", "Bangalore", "TYA7856FG",
				30000, 30, "Manager","pass", "emp101@hotel.com");
		staffRepository.save(staff);

		verify(staffRepository, times(1)).save(staff);
	}

	@Test
	public void updateRoomTest() {
		Staff staff = new Staff("EMP101", "Employee 101", "Bangalore", "TYA7856FG",
				30000, 30, "Manager","pass", "emp101@hotel.com");
		staffRepository.findByEmployeeCode("EMP101");
		staff.setEmployeeAddress("Mumbai");
		staffRepository.save(staff);

		assertThat(staff.getEmployeeAddress()).isEqualTo("Mumbai");
	}

	@Test
	public void deleteRoomTest() {
		Staff staff = new Staff("EMP101", "Employee 101", "Bangalore", "TYA7856FG",
				30000, 30, "Manager","pass", "emp101@hotel.com");
		staffRepository.deleteByEmployeeCode("EMP101");

		assertEquals(null, staffService.getStaffByEmployeeCode("EMP101"));
	}
}

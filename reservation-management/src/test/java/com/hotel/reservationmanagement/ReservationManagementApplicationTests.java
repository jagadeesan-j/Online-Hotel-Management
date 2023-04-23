package com.hotel.reservationmanagement;

import com.hotel.reservationmanagement.entity.Reservation;
import com.hotel.reservationmanagement.entity.Room;
import com.hotel.reservationmanagement.repository.ReservationRepository;
import com.hotel.reservationmanagement.repository.RoomRepository;
import com.hotel.reservationmanagement.service.ReservationService;
import com.hotel.reservationmanagement.service.RoomService;
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
class ReservationManagementApplicationTests {

    @Autowired
    private ReservationService reservationService;

    @MockBean
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomService roomService;

    @MockBean
    private RoomRepository roomRepository;

    @Test
    public void getReservationsTest() {
        when(reservationRepository.findAll()).thenReturn(Stream.of(
                (new Reservation("BKID101", 101, 1, 2, "5-10-2022",
                        "8-10-2022", 3, "Payment Successful")),
                (new Reservation("BKID102", 102, 2, 2, "7-10-2022",
                        "11-10-2022", 4, "Payment Successful")))
                .collect(Collectors.toList()));

        assertEquals(2,reservationService.getAllReservation().size());
    }

    @Test
    public void saveReservationTest() {
        Reservation reservation =new Reservation("BKID101", 101, 1, 2, "5-10-2022",
                "8-10-2022", 3, "Payment Successful");
        reservationRepository.save(reservation);

        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    public void updateReservationTest(){
        Reservation reservation = new Reservation("BKID101", 101, 1, 2, "5-10-2022",
                "8-10-2022", 3, "Payment Successful");
        reservationRepository.findByBookingID("BKID101");
        reservation.setNoOfAdult(3);
        reservationRepository.save(reservation);

        assertThat(reservation.getNoOfAdult()).isEqualTo(3);
    }

    @Test
    public void deleteReservationTest(){
        Reservation reservation =new Reservation("BKID101", 101, 1, 2, "5-10-2022",
                "8-10-2022", 3, "Payment Successful");
        reservationRepository.delete(reservation);

        verify(reservationRepository, times(1)).delete(reservation);
    }

    @Test
    public void getRoomsTest() {
        when(roomRepository.findAll()).thenReturn(Stream.of(
                (new Room(101, "Gold", "Family", "Available")),
                (new Room(101, "Gold", "Family", "Available")))
                .collect(Collectors.toList()));

        assertEquals(2,roomService.getAllRoom().size());
    }

    @Test
    public void saveRoomTest() {
        Room room =new Room(101, "Gold", "Family", "Available");
        roomRepository.save(room);

        verify(roomRepository, times(1)).save(room);
    }

    @Test
    public void updateRoomTest(){
        Room room = new Room(101, "Gold", "Family", "Available");
        roomRepository.findByRoomNumber(101);
        room.setRoomStatus("Unavailable");
        roomRepository.save(room);

        assertThat(room.getRoomStatus()).isEqualTo("Unavailable");
    }

    @Test
    public void deleteRoomTest(){
        Room room = new Room(101, "Gold", "Family", "Available");
        roomRepository.delete(room);

        verify(roomRepository, times(1)).delete(room);
    }
}

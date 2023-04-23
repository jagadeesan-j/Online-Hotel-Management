import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Reservation } from '../reservation';
import { ReservationService } from '../reservation.service';

@Component({
  selector: 'app-reservation-details',
  templateUrl: './reservation-details.component.html',
  styleUrls: ['./reservation-details.component.css']
})
export class ReservationDetailsComponent implements OnInit {

  bookingID!: string;
  reservation!: Reservation;

  constructor(private reservationService: ReservationService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.bookingID = this.activatedRoute.snapshot.params['bookingID'];
    this.reservation = new Reservation();
    this.reservationService.getReservationByBookingID(this.bookingID).subscribe(data => {
      this.reservation = data;
    })
  }

}

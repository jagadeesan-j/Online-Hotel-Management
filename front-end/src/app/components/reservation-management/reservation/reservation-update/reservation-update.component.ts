import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Reservation } from '../reservation';
import { ReservationService } from '../reservation.service';

@Component({
  selector: 'app-reservation-update',
  templateUrl: './reservation-update.component.html',
  styleUrls: ['./reservation-update.component.css']
})
export class ReservationUpdateComponent implements OnInit {

  reservation!: Reservation;
  bookingID!: string;

  constructor(
    private reservationService: ReservationService,
    private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.reservation = new Reservation();
    this.bookingID = this.activatedRoute.snapshot.params['bookingID'];
    this.reservationService.getReservationByBookingID(this.bookingID).subscribe(data => {
      this.reservation = data;
    }, error => console.log(error));
  }

  updateReservation(){
    this.reservationService.updateReservation(this.bookingID, this.reservation).subscribe(data => {
      this.reservation = new Reservation();
      this.routeToReservationList();
    }, error => console.log(error));
  }

  routeToReservationList(){
    this.router.navigate(['reservation/list']);
  }

  onSubmit(){
    this.updateReservation();
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reservation } from '../reservation';
import { ReservationService } from '../reservation.service';

@Component({
  selector: 'app-reservation-add',
  templateUrl: './reservation-add.component.html',
  styleUrls: ['./reservation-add.component.css']
})
export class ReservationAddComponent implements OnInit {

  reservation: Reservation = new Reservation();

  constructor(private reservationService: ReservationService, private router: Router) { }

  ngOnInit(): void {
  }

  addReservation(){
    this.reservationService.addReservation(this.reservation).subscribe(data => {
      console.log(data);
      this.routeToReservationList();
    },
    error => console.log(error));
  }

  routeToReservationList(){
    this.router.navigate(['/reservation/list']);
  }

  onSubmit(){
    this.addReservation();
  }
}

import { Component, OnInit } from '@angular/core';
import { bootstrapApplication } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { Reservation } from '../reservation';
import { ReservationService } from '../reservation.service';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {

  reservationList: Reservation[] = [];

  constructor(private reservationService: ReservationService, private router: Router) { }

  ngOnInit(): void {
    this.getReservationList();
  }

  private getReservationList() {
    this.reservationService.getReservationList().subscribe(data => {
      this.reservationList = data;
      console.log(data);
    });
  }

  updateReservation(bookingID: string){
    this.router.navigate(['/reservation/update/', bookingID]);
  }

  deleteReservation(bookingID: string){
    this.reservationService.deleteReservation(bookingID).subscribe(data => {
      console.log(data);
      this.router.navigate(['/reservation/list']);
    })
  }

  reservationDetails(bookingID: string){
    this.router.navigate(['/reservation/details', bookingID]);
  }
}

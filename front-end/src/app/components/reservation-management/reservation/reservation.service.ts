import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reservation } from './reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private baseURL = "http://localhost:9090/reservation";

  constructor(private httpClient: HttpClient) { }

  getReservationList(): Observable<Reservation[]>{
    return this.httpClient.get<Reservation[]>(`${this.baseURL+'/all'}`);
  }

  addReservation(reservation: Reservation): Observable<Object>{
    return this.httpClient.post(`${this.baseURL+'/add'}`, reservation);
  }

  getReservationByBookingID(bookingID: string): Observable<Reservation>{
    return this.httpClient.get<Reservation>(`${this.baseURL+'/getByBookingID/'}${bookingID}`);
  }

  updateReservation(bookingID: string, reservation: Reservation): Observable<Object>{
    return this.httpClient.put(`${this.baseURL+'/updateByBookingID/'}${bookingID}`, reservation);
  }

  deleteReservation(bookingID: string): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL+'/deleteByBookingID/'}${bookingID}`);
  }
}

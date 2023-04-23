import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Guest } from './guest';

@Injectable({
  providedIn: 'root'
})
export class GuestService {

  private baseURL = "http://localhost:9090/guest";

  constructor(private httpClient: HttpClient) { }

  getGuestList(): Observable<Guest[]>{
    return this.httpClient.get<Guest[]>(`${this.baseURL+'/all'}`)
  }

  addGuest(guest: Guest): Observable<Object>{
    return this.httpClient.post(`${this.baseURL+'/add'}`, guest)
  }

  getGuestByMemberCode(memberCode: number): Observable<Guest>{
    return this.httpClient.get<Guest>(`${this.baseURL+'/getGuestByMemberCode/'}${memberCode}`);
  }

  updateGuest(memberCode: number, guest: Guest): Observable<Object>{
    return this.httpClient.put(`${this.baseURL+'/update/'}${memberCode}`, guest);
  }

  deleteGuest(memberCode: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL+'/deleteByMemberCode/'}${memberCode}`);
  }
}

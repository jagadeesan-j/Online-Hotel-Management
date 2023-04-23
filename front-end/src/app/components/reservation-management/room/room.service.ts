import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Room } from './room';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseURL = "http://localhost:9090/reservation/room";

  constructor(private httpClient: HttpClient) { }

  getRoomList(): Observable<Room[]>{
    return this.httpClient.get<Room[]>(`${this.baseURL+'/all'}`);
  }

  addRoom(room: Room): Observable<Object>{
    return this.httpClient.post(`${this.baseURL+'/add'}`, room);
  }

  getRoomByRoomNumber(roomNumber: number): Observable<Room>{
    return this.httpClient.get<Room>(`${this.baseURL+'/getByRoomNumber/'}${roomNumber}`);
  }

  updateRoom(roomNumber: number, room: Room): Observable<Object>{
    return this.httpClient.put(`${this.baseURL+'/updateByRoomNumber/'}${roomNumber}`, room);
  }

  deleteRoom(roomNumber: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL+'/deleteByRoomNumber/'}${roomNumber}`);
  }
}

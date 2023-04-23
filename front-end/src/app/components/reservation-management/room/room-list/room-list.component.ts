import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Room } from '../room';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {

  roomList: Room[] = [];

  constructor(private roomService: RoomService, private router: Router) { }

  ngOnInit(): void {
    this.getRoomList();
  }

  private getRoomList() {
    this.roomService.getRoomList().subscribe(data => {
      this.roomList = data;
      console.log(data);
    });
  }

  updateRoom(roomNumber: number){
    this.router.navigate(['/reservation/room/update/', roomNumber]);
  }

  deleteRoom(roomNumber: number){
    this.roomService.deleteRoom(roomNumber).subscribe(data => {
      console.log(data);
      this.router.navigate(['/reservation/room/list']);
    })
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Room } from '../room';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-room-add',
  templateUrl: './room-add.component.html',
  styleUrls: ['./room-add.component.css']
})
export class RoomAddComponent implements OnInit {

  room: Room = new Room();

  constructor(private roomService: RoomService, private router: Router) { }

  ngOnInit(): void {
  }

  addRoom(){
    this.roomService.addRoom(this.room).subscribe(data => {
      console.log(data);
      this.routeToRoomList();
    },
    error => console.log(error));
  }

  routeToRoomList(){
    this.router.navigate(['/reservation/room/list']);
  }

  onSubmit(){
    this.addRoom();
  }
}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Room } from '../room';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-room-update',
  templateUrl: './room-update.component.html',
  styleUrls: ['./room-update.component.css']
})
export class RoomUpdateComponent implements OnInit {

  room!: Room;
  roomNumber!: number;

  constructor(
    private roomService: RoomService,
    private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.room = new Room();
    this.roomNumber = this.activatedRoute.snapshot.params['roomNumber'];
    this.roomService.getRoomByRoomNumber(this.roomNumber).subscribe(data => {
      this.room = data;
    }, error => console.log(error));
  }

  updateRoom(){
    this.roomService.updateRoom(this.roomNumber, this.room).subscribe(data => {
      this.room = new Room();
      this.routeToRoomList();
    }, error => console.log(error));
  }

  routeToRoomList(){
    this.router.navigate(['reservation/room/list']);
  }

  onSubmit(){
    this.updateRoom();
  }
}

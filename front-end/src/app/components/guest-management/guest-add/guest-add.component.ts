import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-guest-add',
  templateUrl: './guest-add.component.html',
  styleUrls: ['./guest-add.component.css']
})
export class GuestAddComponent implements OnInit {

  guest: Guest = new Guest();

  constructor(private guestService: GuestService, private router: Router) { }

  ngOnInit(): void {
  }

  addGuest(){
    this.guestService.addGuest(this.guest).subscribe(data => {
      console.log(data);
      this.routeToGuestList();
    },
    error => console.log(error));
  }

  routeToGuestList(){
    this.router.navigate(['/guest/list'])
  }

  onSubmit(){
    this.addGuest();
  }

}

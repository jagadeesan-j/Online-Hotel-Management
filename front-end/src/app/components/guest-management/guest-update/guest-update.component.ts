import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-guest-update',
  templateUrl: './guest-update.component.html',
  styleUrls: ['./guest-update.component.css']
})
export class GuestUpdateComponent implements OnInit {

  guest!: Guest;
  memberCode!: number;

  constructor(private guestService: GuestService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.guest = new Guest();
    this.memberCode = this.activatedRoute.snapshot.params['memberCode'];
    this.guestService.getGuestByMemberCode(this.memberCode).subscribe(data => {this.guest=data;}, error => console.log(error));
  }

  updateGuest(){
    this.guestService.updateGuest(this.memberCode, this.guest).subscribe(data => {
      this.guest = new Guest();
      this.routeToGuestList();
    }, error => console.log(error));
  }

  routeToGuestList(){
    this.router.navigate(['/guest/list'])
  }

  onSubmit(){
    this.updateGuest();
  }
}

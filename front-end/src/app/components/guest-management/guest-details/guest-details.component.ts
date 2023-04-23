import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-guest-details',
  templateUrl: './guest-details.component.html',
  styleUrls: ['./guest-details.component.css']
})
export class GuestDetailsComponent implements OnInit {

  memberCode!: number;
  guest!: Guest;

  constructor(private guestService: GuestService, private activaedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.memberCode = this.activaedRoute.snapshot.params['memberCode'];

    this.guest = new Guest();
    this.guestService.getGuestByMemberCode(this.memberCode).subscribe(data => {
      this.guest = data;
    })
  }

}

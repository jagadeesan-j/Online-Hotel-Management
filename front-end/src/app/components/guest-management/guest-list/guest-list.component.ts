import { Component, OnInit } from '@angular/core';
import { MatButton } from '@angular/material/button';
import { Router } from '@angular/router';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-guest-list',
  templateUrl: './guest-list.component.html',
  styleUrls: ['./guest-list.component.css']
})
export class GuestListComponent implements OnInit {

  guestList: Guest[] = [];

  constructor(private guestService: GuestService, private router: Router) { }

  ngOnInit(): void {
    this.getGuestList();
  }

  private getGuestList(){
    this.guestService.getGuestList().subscribe(data => {
      this.guestList = data;
      console.log(data);
    });
  }


  updateGuest(memberCode: number){
    this.router.navigate(['/guest/update', memberCode]);
  }

  deleteGuest(memberCode: number){
    this.guestService.deleteGuest(memberCode).subscribe(data => {
      console.log(data);
      this.router.navigate(['/guest/list']);
    })
  }

  guestDetails(memberCode: number){
    this.router.navigate(['/guest/details', memberCode]);
  }

  // columns = [
  //   {
  //     columnDef: 'memberCode',
  //     header: 'Member Code',
  //     cell: (guest: Guest) => `${guest.memberCode}`,
  //   },
  //   {
  //     columnDef: 'name',
  //     header: 'Name',
  //     cell: (guest: Guest) => `${guest.name}`,
  //   },
  //   {
  //     columnDef: 'gender',
  //     header: 'Gender',
  //     cell: (guest: Guest) => `${guest.gender}`,
  //   },
  //   {
  //     columnDef: 'phoneNumber',
  //     header: 'Phone Number',
  //     cell: (guest: Guest) => `${guest.phoneNumber}`,
  //   },
  // ];

  // dataSource = this.guestList;
  // displayedColumns = this.columns.map(c => c.columnDef);
}

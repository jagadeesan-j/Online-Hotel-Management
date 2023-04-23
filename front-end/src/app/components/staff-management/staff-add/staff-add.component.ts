import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Staff } from '../staff';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-staff-add',
  templateUrl: './staff-add.component.html',
  styleUrls: ['./staff-add.component.css']
})
export class StaffAddComponent implements OnInit {

  staff: Staff = new Staff();

  constructor(private staffService: StaffService, private router: Router) { }

  ngOnInit(): void {
  }

  addStaff(){
    this.staffService.addStaff(this.staff).subscribe(data => {
      console.log(data);
      this.routeToStaffList();
    },
    error => console.log(error));
  }

  routeToStaffList(){
    this.router.navigate(['/staff/list'])
  }

  onSubmit(){
    this.addStaff();
  }
}

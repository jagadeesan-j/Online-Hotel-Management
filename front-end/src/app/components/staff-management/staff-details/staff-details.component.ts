import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Staff } from '../staff';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-staff-details',
  templateUrl: './staff-details.component.html',
  styleUrls: ['./staff-details.component.css']
})
export class StaffDetailsComponent implements OnInit {

  employeeCode!: string;
  staff!: Staff;

  constructor(private staffService: StaffService, private activaedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.employeeCode = this.activaedRoute.snapshot.params['employeeCode'];

    this.staff = new Staff();
    this.staffService.getStaffByEmployeeCode(this.employeeCode).subscribe(data => {
      this.staff = data;
    })
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Staff } from '../staff';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-staff-update',
  templateUrl: './staff-update.component.html',
  styleUrls: ['./staff-update.component.css']
})
export class StaffUpdateComponent implements OnInit {

  staff!: Staff;
  employeeCode!: string;

  constructor(
    private staffService: StaffService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.staff = new Staff();
    this.employeeCode = this.activatedRoute.snapshot.params['employeeCode'];
    this.staffService.getStaffByEmployeeCode(this.employeeCode).subscribe(data => {
      this.staff=data;},
      error => console.log(error));
  }

  updateStaff(){
    this.staffService.updateStaff(this.employeeCode, this.staff).subscribe(data => {
      this.staff = new Staff();
      this.routeToStaffList();
    }, error => console.log(error));
  }

  routeToStaffList(){
    this.router.navigate(['/staff/list'])
  }

  onSubmit(){
    this.updateStaff();
  }
}

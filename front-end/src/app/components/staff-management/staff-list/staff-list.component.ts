import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Staff } from '../staff';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-staff-list',
  templateUrl: './staff-list.component.html',
  styleUrls: ['./staff-list.component.css']
})
export class StaffListComponent implements OnInit {

  staffList: Staff[] = [];

  constructor(private staffService: StaffService, private router: Router) { }

  ngOnInit(): void {
    this.getStaffList();
  }

  private getStaffList(){
    this.staffService.getStaffList().subscribe(data => {
      this.staffList = data;
      console.log(data);
    });
  }

  updateStaff(employeeCode: string){
    this.router.navigate(['/staff/update', employeeCode]);
  }

  deleteStaff(employeeCode: string){
    this.staffService.deleteStaff(employeeCode).subscribe(data => {
      console.log(data);
      this.router.navigate(['/staff/list']);
    })
  }

  staffDetails(employeeCode: string){
    this.router.navigate(['/staff/details', employeeCode]);
  }
}

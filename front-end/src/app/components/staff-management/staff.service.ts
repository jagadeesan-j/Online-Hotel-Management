import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Staff } from './staff';

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  private baseURL = "http://localhost:9090/staff";

  constructor(private httpClient: HttpClient) { }

  getStaffList(): Observable<Staff[]>{
    return this.httpClient.get<Staff[]>(`${this.baseURL+'/all'}`)
  }

  addStaff(staff: Staff): Observable<Object>{
    return this.httpClient.post(`${this.baseURL+'/add'}`, staff)
  }

  getStaffByEmployeeCode(employeeCode: string): Observable<Staff>{
    return this.httpClient.get<Staff>(`${this.baseURL+'/getByEmployeeCode/'}${employeeCode}`);
  }

  updateStaff(employeeCode: string, staff: Staff): Observable<Object>{
    return this.httpClient.put(`${this.baseURL+'/updateByEmployeeCode/'}${employeeCode}`, staff);
  }

  deleteStaff(employeeCode: string): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL+'/deleteByEmployeeCode/'}${employeeCode}`);
  }
}

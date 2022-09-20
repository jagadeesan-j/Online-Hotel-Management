package com.hotel.staffmanagement.service;

import com.hotel.staffmanagement.entity.Staff;

import java.util.List;

public interface StaffService {

    Staff addStaff(Staff staff);

    List<Staff> getAllStaff();

    Staff getStaffByEmployeeCode(int employeeCode);

    Staff updateStaffByEmployeeCode(int employeeCode,Staff newStaff);

    void deleteStaffByEmployeeCode(int employeeCode);

}

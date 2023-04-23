package com.hotel.staffmanagement.service;

import com.hotel.staffmanagement.entity.Staff;

import java.util.List;

public interface StaffService {

    Staff addStaff(Staff staff);

    List<Staff> getAllStaff();

    Staff getStaffByEmployeeCode(String employeeCode);

    Staff updateStaffByEmployeeCode(String employeeCode,Staff newStaff);

    void deleteStaffByEmployeeCode(String employeeCode);

//    public void init();
}

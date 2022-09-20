package com.hotel.staffmanagement.service.impl;

import com.hotel.staffmanagement.entity.Staff;
import com.hotel.staffmanagement.repository.StaffRepository;
import com.hotel.staffmanagement.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getStaffByEmployeeCode(int employeeCode) {
        return staffRepository.findByEmployeeCode(employeeCode);
    }

    @Override
    public Staff updateStaffByEmployeeCode(int employeeCode, Staff newStaff) {
        Staff oldStaff = staffRepository.findByEmployeeCode(employeeCode);

        if (oldStaff != null) {
            if (newStaff.getEmployeeName() != null && !newStaff.getEmployeeName().isEmpty())
                oldStaff.setEmployeeName(newStaff.getEmployeeName());

            if (newStaff.getEmployeeAddress() != null && !newStaff.getEmployeeAddress().isEmpty())
                oldStaff.setEmployeeAddress(newStaff.getEmployeeAddress());

            if (newStaff.getPanCard() != null && !newStaff.getPanCard().isEmpty())
                oldStaff.setPanCard(newStaff.getPanCard());

            if (newStaff.getSalary() >= 0.0)
                oldStaff.setSalary(newStaff.getSalary());

            if (newStaff.getAge() >= 0.0)
                oldStaff.setAge(newStaff.getAge());

            if (newStaff.getRole() != null && !newStaff.getRole().isEmpty())
                oldStaff.setRole(newStaff.getRole());

            if (newStaff.getEmail() != null && !newStaff.getEmail().isEmpty())
                oldStaff.setEmail(newStaff.getEmail());

            return staffRepository.save(oldStaff);
        } else
            return null;
    }

    @Override
    public void deleteStaffByEmployeeCode(int employeeCode) {
        staffRepository.deleteByEmployeeCode(employeeCode);
    }
}

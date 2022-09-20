package com.hotel.staffmanagement.controller;

import com.hotel.staffmanagement.entity.Staff;
import com.hotel.staffmanagement.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    Logger logger = LoggerFactory.getLogger(StaffController.class);

    @GetMapping("/test")
    public String test(){
        logger.debug("Staff test endpoint called.");
        return "Testing staff controller";
    }

    @PostMapping("/add")
    public Staff addStaff(@RequestBody Staff staff){
        logger.debug("Add staff endpoint called.");
        return staffService.addStaff(staff);
    }

    @GetMapping("/all")
    public List<Staff> getAllStaff(){
        logger.debug("List all staff endpoint called.");
        return staffService.getAllStaff();
    }

    @GetMapping("/getByEmployeeCode/{employeeCode}")
    public Staff getStaffByEmployeeCode(@PathVariable("employeeCode")int employeeCode){
        logger.debug("Get staff by employee code endpoint called.");
        return staffService.getStaffByEmployeeCode(employeeCode);
    }

    @PutMapping("/updateByEmployeeCode/{employeeCode}")
    public Staff updateStaff(@RequestBody Staff newStaff, @PathVariable("employeeCode") int employeeCode ) {
        logger.debug("Update staff by employee code endpoint called.");
        return staffService.updateStaffByEmployeeCode(employeeCode, newStaff);
    }

    @DeleteMapping("/deleteByEmployeeCode/{employeeCode}")
    public String deleteStaffByEmployeeCode(@PathVariable("employeeCode")int employeeCode){
        staffService.deleteStaffByEmployeeCode(employeeCode);
        logger.debug("Delete staff by employee code endpoint called.");
        return "Deleted Successfully.";
    }


}

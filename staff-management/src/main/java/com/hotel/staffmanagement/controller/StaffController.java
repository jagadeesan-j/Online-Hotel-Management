package com.hotel.staffmanagement.controller;

import com.hotel.staffmanagement.entity.Staff;
import com.hotel.staffmanagement.service.StaffService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Tests Staff Controller.",
            notes = "This API returns a string if the controller is working fine.",
            response = String.class)
    public String test(){
        logger.info("Staff test endpoint called.");
        return "Testing staff controller";
    }

    @PostMapping("/add")
    public Staff addStaff(@RequestBody Staff staff){
        logger.info("Add staff endpoint called.");
        return staffService.addStaff(staff);
    }

    @GetMapping("/all")
    public List<Staff> getAllStaff(){
        logger.info("List all staff endpoint called.");
        return staffService.getAllStaff();
    }

    @GetMapping("/getByEmployeeCode/{employeeCode}")
    public Staff getStaffByEmployeeCode(@PathVariable("employeeCode")int employeeCode){
        logger.info("Get staff by employee code endpoint called.");
        return staffService.getStaffByEmployeeCode(employeeCode);
    }

    @PutMapping("/updateByEmployeeCode/{employeeCode}")
    public Staff updateStaff(@RequestBody Staff newStaff, @PathVariable("employeeCode") int employeeCode ) {
        logger.info("Update staff by employee code endpoint called.");
        return staffService.updateStaffByEmployeeCode(employeeCode, newStaff);
    }

    @DeleteMapping("/deleteByEmployeeCode/{employeeCode}")
    public String deleteStaffByEmployeeCode(@PathVariable("employeeCode")int employeeCode){
        staffService.deleteStaffByEmployeeCode(employeeCode);
        logger.info("Delete staff by employee code endpoint called.");
        return "Deleted Successfully.";
    }


}

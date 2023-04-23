package com.hotel.staffmanagement.controller;

import com.hotel.staffmanagement.entity.Staff;
import com.hotel.staffmanagement.service.StaffService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @PostConstruct
//    public void init() {
//        staffService.init();
//    }

    Logger logger = LoggerFactory.getLogger(StaffController.class);

    @GetMapping("/test")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'RECEPTIONIST')")
    @ApiOperation(value = "Tests Staff Controller.",
            notes = "This API returns a string if the controller is working fine.",
            response = String.class)
    public String test(){
        logger.info("Staff test endpoint called.");
        return "Testing staff controller";
    }


    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public Staff addStaff(@Valid @RequestBody Staff staff){
        logger.info("Add staff endpoint called.");
        return staffService.addStaff(staff);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'RECEPTIONIST')")
    public List<Staff> getAllStaff(){
        logger.info("List all staff endpoint called.");
        return staffService.getAllStaff();
    }

    @GetMapping("/getByEmployeeCode/{employeeCode}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public Staff getStaffByEmployeeCode(@PathVariable("employeeCode") String employeeCode){
        logger.info("Get staff by employee code endpoint called.");
        return staffService.getStaffByEmployeeCode(employeeCode);
    }

    @PutMapping("/updateByEmployeeCode/{employeeCode}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public Staff updateStaff(@Valid @RequestBody Staff newStaff, @PathVariable("employeeCode") String employeeCode ) {
        logger.info("Update staff by employee code endpoint called.");
        return staffService.updateStaffByEmployeeCode(employeeCode, newStaff);
    }

    @DeleteMapping("/deleteByEmployeeCode/{employeeCode}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String deleteStaffByEmployeeCode(@PathVariable String employeeCode){
        staffService.deleteStaffByEmployeeCode(employeeCode);
        logger.info("Delete staff by employee code endpoint called.");
        return "Deleted Successfully.";
    }
}

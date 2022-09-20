package com.hotel.staffmanagement.repository;

import com.hotel.staffmanagement.entity.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StaffRepository extends MongoRepository<Staff,Integer> {

    Staff findByEmployeeCode(int employeeCode);

    Staff deleteByEmployeeCode(int employeeCode);
}

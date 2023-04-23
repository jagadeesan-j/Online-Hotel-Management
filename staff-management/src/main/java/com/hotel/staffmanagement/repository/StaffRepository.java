package com.hotel.staffmanagement.repository;

import com.hotel.staffmanagement.entity.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StaffRepository extends MongoRepository<Staff, String> {

    Staff findByEmployeeCode(String employeeCode);

    void deleteByEmployeeCode(String employeeCode);
}

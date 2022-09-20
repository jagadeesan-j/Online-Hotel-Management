package com.hotel.staffmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Staff {

    @Id
    private int employeeCode;
    private String employeeName;
    private String employeeAddress;
    private String panCard;
    private float salary;
    private int age;
    private String role;
    private String email;

    public Staff() {
    }

    public Staff(int employeeCode, String employeeName, String employeeAddress, String panCard, float salary, int age, String role, String email)
    {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.panCard = panCard;
        this.salary = salary;
        this.age = age;
        this.role = role;
        this.email = email;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

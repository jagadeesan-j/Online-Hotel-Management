package com.hotel.staffmanagement.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.*;

@Document
public class Staff {

    @Id
    private String employeeCode;

    @NotBlank(message = "Name is mandatory.")
    @Size(min = 2, message = "Name should have at least 2 characters.")
    private String employeeName;

    @NotBlank(message = "Address is mandatory")
    private String employeeAddress;

    @NotBlank(message = "PAN Card is mandatory")
    private String panCard;

    @NotNull
    @PositiveOrZero()
    private float salary;

    @NotNull
    @Min(18)
    private int age;

    @NotEmpty(message = "Role is mandatory")
    private String role;

    @NotBlank(message = "Password is mandatory.")
    @Size(min = 8, message = "Password should have at least 8 characters.")
    private String password;

    @NotBlank(message = "Must provide email.")
    @Email(message = "Must provide in xyz@mail.com format.")
    private String email;

    public Staff() {
    }

    public Staff(String employeeCode, String employeeName, String employeeAddress, String panCard, float salary, int age,
                 String role, String password, String email)
    {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.panCard = panCard;
        this.salary = salary;
        this.age = age;
        this.role = role;
        this.password = password;
        this.email = email;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "employeeCode=" + employeeCode +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", panCard='" + panCard + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

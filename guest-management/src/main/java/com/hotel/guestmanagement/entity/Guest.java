package com.hotel.guestmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

@Document
public class Guest {

    @Id
//    @NotBlank(message = "Invalid! Member Code should be 3 digits only.")
//    @Pattern(regexp = "\\d{3}")
    @NotNull
    private int memberCode;

//    @Pattern(regexp = "\\d{10}", message = "Invalid! Phone number should be 10 digits only.")
    @NotNull
    private long phoneNumber;

    @NotBlank(message = "Company is mandatory.")
    private String company;

    @NotBlank(message = "Name is mandatory.")
    @Size(min = 2, message = "Name should have at least 2 characters.")
    private String name;

    @NotBlank(message = "Must provide email.")
    @Email(message = "Invalid! Must provide in xyz@mail.com format.")
    private String email;

    @NotBlank(message = "Gender can't be empty.")
    private String gender;

    @NotBlank(message = "Address is mandatory")
    private String address;

    public Guest() {
    }

    public Guest(int memberCode, long phoneNumber, String company, String name, String email, String gender,
                 String address) {
        this.memberCode = memberCode;
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.address = address;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

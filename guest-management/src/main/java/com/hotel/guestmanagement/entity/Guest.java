package com.hotel.guestmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Guest {

    @Id
    private int memberCode;
    private int phoneNumber;
    private String company;
    private String name;
    private String email;
    private String gender;
    private String address;

    public Guest() {
    }

    public Guest(int memberCode, int phoneNumber, String company, String name, String email, String gender,
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
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

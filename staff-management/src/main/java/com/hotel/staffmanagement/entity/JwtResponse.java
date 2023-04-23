package com.hotel.staffmanagement.entity;

public class JwtResponse {

    private Staff staff;
    private String jwtToken;

    public JwtResponse(Staff staff, String jwtToken) {
        this.staff = staff;
        this.jwtToken = jwtToken;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}

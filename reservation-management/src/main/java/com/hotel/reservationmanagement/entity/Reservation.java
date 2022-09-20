package com.hotel.reservationmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Reservation {

    @Id
    private String bookingID;
    private int memberCode;
    private int noOfChildren;
    private int noOfAdult;
    private String checkInDate;
    private String checkOutDate;
    private int noOfNights;
    private String paymentStatus;

    public Reservation() {
    }

    public Reservation(String bookingID,int memberCode, int noOfChildren, int noOfAdult, String checkInDate, String checkOutDate,
                       int noOfNights, String paymentStatus) {
        this.bookingID = bookingID;
        this.memberCode = memberCode;
        this.noOfChildren = noOfChildren;
        this.noOfAdult = noOfAdult;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfNights = noOfNights;
        this.paymentStatus = paymentStatus;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public int getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public int getNoOfAdult() {
        return noOfAdult;
    }

    public void setNoOfAdult(int noOfAdult) {
        this.noOfAdult = noOfAdult;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNoOfNights() {
        return noOfNights;
    }

    public void setNoOfNights(int noOfNights) {
        this.noOfNights = noOfNights;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}

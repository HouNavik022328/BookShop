/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.orders;

/**
 *
 * @author VODUCMINH
 */
public class ShippingInfo {
    private String fullName;
    private String address;
    private String city;
    private String state;
    private String phone;
    private String note;
    private String orderID;
    private int statusID;

    public ShippingInfo() {
    }

    public ShippingInfo(String fullName, String address, String city, String state, String phone, String note, String orderID, int statusID) {
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.note = note;
        this.orderID = orderID;
        this.statusID = statusID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.users;

/**
 *
 * @author VODUCMINH
 */
public class UserDTO {
    private String userID;
    private String userName;
    private String userAddress;
    private String userPhone;
    private String password;
    private String createDate;
    private String email;
    private String userStatus;
    private int roleID;

    public UserDTO() {
    }

    public UserDTO(String userID, String userName, String userAddress, String userPhone, String password, String createDate, String email, String userStatus, int roleID) {
        this.userID = userID;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.password = password;
        this.createDate = createDate;
        this.email = email;
        this.userStatus = userStatus;
        this.roleID = roleID;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getPassword() {
        return password;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getEmail() {
        return email;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", userName=" + userName + ", userAddress=" + userAddress + ", userPhone=" + userPhone + ", password=" + password + ", createDate=" + createDate + ", email=" + email + ", userStatus=" + userStatus + ", roleID=" + roleID + '}';
    }
}

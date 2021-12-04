/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.orders;

import com.bookshop.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author VODUCMINH
 */
public class OrderDAO {
    public boolean insertOrder(Order order) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            String orderID = order.getOrderID();
            String userID = order.getUserID();
            double totalPrice = order.getTotalPrice();
            String createDate = order.getCreateDate();
            
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "INSERT INTO tblorder(orderID, userID, totalPrice, createDate) "
                            + " VALUES(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, orderID);
                stm.setString(2, userID);
                stm.setDouble(3, totalPrice);
                stm.setString(4, createDate);
                
                check = stm.executeUpdate() > 0;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (stm != null) {
                stm.close();;
            }
            if (conn != null) {
                conn.close();;
            }
        }
        
        return check;
    }
    
    public boolean insertShippingInfo(ShippingInfo info) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            String fullName = info.getFullName();
            String address = info.getAddress();
            String city = info.getCity();
            String state = info.getState();
            String phone = info.getPhone();
            String note = info.getNote();
            String orderID = info.getOrderID();
            int statusID = info.getStatusID();
            
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "INSERT INTO tblshippinginfo(fullName, address, city, state, phone, note, orderID) "
                            + " VALUES(?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, fullName);
                stm.setString(2, address);
                stm.setString(3, city);
                stm.setString(4, state);
                stm.setString(5, phone);
                stm.setString(6, note);
                stm.setString(7, orderID);
                
                check = stm.executeUpdate() > 0;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (stm != null) {
                stm.close();;
            }
            if (conn != null) {
                conn.close();;
            }
        }
        
        return check;
    }
    
    public boolean insertOrderDetail(OrderDetail orderDetail) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            String detailID = orderDetail.getDetailID();
            String orderID = orderDetail.getOrderID();
            String productID = orderDetail.getProductID();
            double detailPrice = orderDetail.getDetailPrice();
            int quantity = orderDetail.getQuantity();
            
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "INSERT INTO tblorderdetail(detailID, orderID, bookID, detailPrice, quantity) "
                            + " VALUES(?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, detailID);
                stm.setString(2, orderID);
                stm.setString(3, productID);
                stm.setDouble(4, detailPrice);
                stm.setInt(5, quantity);
                
                check = stm.executeUpdate() > 0;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (stm != null) {
                stm.close();;
            }
            if (conn != null) {
                conn.close();;
            }
        }
        
        return check;
    }
}

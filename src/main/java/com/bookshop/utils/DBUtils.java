/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author VODUCMINH
 */
public class DBUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        final String url = "jdbc:mysql://localhost:3306/bookshop";
        final String user = "root";
        final String password = "Phanvantau123@" ; //DATABASE PASSWORD
        
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    
}

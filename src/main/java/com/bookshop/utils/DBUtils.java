
package com.bookshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

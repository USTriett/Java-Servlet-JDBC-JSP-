package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
    public static Connection getJDBCConnection() {
        final String url = "jdbc:mysql://localhost:10001/studentManagement1?useUnicode=yes&characterEncoding=UTF-8";
        final String user = "root";
        final String password = "Uel.123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Cannot connect");
        return null;
    }
}
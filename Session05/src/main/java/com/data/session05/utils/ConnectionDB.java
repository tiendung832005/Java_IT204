package com.data.session05.utils;

import java.sql.CallableStatement;
import java.sql.Connection;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    public static Connection openConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(Connection con, CallableStatement callSt) {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

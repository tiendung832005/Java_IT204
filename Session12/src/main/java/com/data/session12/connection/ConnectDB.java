package com.data.session12.connection;

import java.sql.Connection;

public class ConnectDB {
    private static final String URL = "jdbc:mysql://localhost:3306/session12";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
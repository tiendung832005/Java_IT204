package com.data.session06.dao;


import com.data.session06.model.User;

import java.sql.*;

public class UserDao {
    private final String jdbcURL = "jdbc:mysql://localhost:3306";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "password";

    private static final String INSERT_USER_SQL = "INSERT INTO users (username, password, email, phone) VALUES (?, ?, ?, ?)";
    private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void registerUser(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.executeUpdate();
        }
    }

    public User getUserByUsername(String username) throws SQLException {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("email"), rs.getString("phone"));
            }
        }
        return user;
    }
}

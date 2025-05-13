package com.data.session06.dao;


import java.sql.*;

public class ProductCartDao {
    private final String jdbcURL = "jdbc:mysql://localhost:3306";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "password";

    private static final String INSERT_CART_SQL = "INSERT INTO productCarts (user_id, product_id, quantity) VALUES (?, ?, ?)";
    private static final String DELETE_CART_SQL = "DELETE FROM productCarts WHERE id = ?";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void addToCart(int userId, int productId, int quantity) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART_SQL)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, productId);
            preparedStatement.setInt(3, quantity);
            preparedStatement.executeUpdate();
        }
    }

    public void removeFromCart(int cartId) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_SQL)) {
            preparedStatement.setInt(1, cartId);
            preparedStatement.executeUpdate();
        }
    }
}

package com.data.session06.dao;


import com.data.session06.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private final String jdbcURL = "jdbc:mysql://localhost:3306";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "password";

    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM products";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("image_url")));
            }
        }
        return products;
    }
}

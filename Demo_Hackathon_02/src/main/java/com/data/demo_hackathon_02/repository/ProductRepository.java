package com.data.demo_hackathon_02.repository;


import com.data.demo_hackathon_02.config.DatabaseConfig;
import com.data.demo_hackathon_02.dto.ProductDTO;
import com.data.demo_hackathon_02.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Product";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("Product_name"));
                product.setPrice(rs.getInt("price"));
                product.setDescription(rs.getString("description"));
                product.setImage(rs.getString("image"));
                product.setStatus(rs.getString("status"));
                product.setCreatedAt(rs.getString("created_at"));
                products.add(product);
            }
        }
        return products;
    }

    public void update(int id, ProductDTO productDTO) throws SQLException {
        String query = "UPDATE Product SET Product_name = ?, price = ?, description = ?, status = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, productDTO.getProductName());
            stmt.setInt(2, productDTO.getPrice());
            stmt.setString(3, productDTO.getDescription());
            stmt.setString(4, productDTO.getStatus());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }


    public void delete(int id) throws SQLException {
        String query = "DELETE FROM Product WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Product> search(String keyword) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Product WHERE Product_name LIKE ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + keyword + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setProductName(rs.getString("Product_name"));
                    product.setPrice(rs.getInt("price"));
                    product.setDescription(rs.getString("description"));
                    product.setImage(rs.getString("image"));
                    product.setStatus(rs.getString("status"));
                    product.setCreatedAt(rs.getString("created_at"));
                    products.add(product);
                }
            }
        }
        return products;
    }
}

package com.data.session09.Connect;


import com.data.session09.model.Customer;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class Connection {
    private final String url = "jdbc:mysql://localhost:3306/session09";
    private final String username = "root";
    private final String password = "12345678";
    private String query;

    public Customer findByUsername(String username) {
        try (java.sql.Connection connection = DriverManager.getConnection(url, this.username, this.password)) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setUsername(resultSet.getString("username"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setAddress(resultSet.getString("address"));
                customer.setGender(resultSet.getString("gender"));
                customer.setEmail(resultSet.getString("email"));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    
}

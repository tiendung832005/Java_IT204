package com.data.session09.dao;


import com.data.session09.model.Ticket;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class TicketDAO {
    private final String url = "jdbc:mysql://localhost:3306/session09";
    private final String username = "root";
    private final String password = "12345678";

    public void addTicket(Ticket ticket) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO tickets (customerId, scheduleId, totalMoney, created_at) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, ticket.getCustomerId());
            statement.setLong(2, ticket.getScheduleId());
            statement.setDouble(3, ticket.getTotalMoney());
            statement.setTimestamp(4, new java.sql.Timestamp(ticket.getCreatedAt().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

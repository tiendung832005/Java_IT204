package com.data.session12.repository;


import com.data.session12.model.Bus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusRepository {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
    }

    public void save(Bus bus) throws SQLException {
        String sql = "INSERT INTO bus (license_plate, bus_type, row_seat, col_seat, image) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, bus.getLicensePlate());
            stmt.setString(2, bus.getBusType());
            stmt.setInt(3, bus.getRowSeat());
            stmt.setInt(4, bus.getColSeat());
            stmt.setString(5, bus.getImage());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int busId = generatedKeys.getInt(1);
                    createSeats(busId, bus.getBusType(), bus.getRowSeat(), bus.getColSeat());
                }
            }
        }
    }

    private void createSeats(int busId, String busType, int rowSeat, int colSeat) throws SQLException {
        String sql = "INSERT INTO seat (name_seat, price, bus_id) VALUES (?, ?, ?)";
        double price = switch (busType) {
            case "VIP" -> 150000;
            case "LUXURY" -> 200000;
            default -> 100000;
        };

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 1; i <= rowSeat; i++) {
                for (int j = 1; j <= colSeat; j++) {
                    String seatName = String.format("%c%d", 'A' + (i - 1), j);
                    stmt.setString(1, seatName);
                    stmt.setDouble(2, price);
                    stmt.setInt(3, busId);
                    stmt.addBatch();
                }
            }
            stmt.executeBatch();
        }
    }

    public List<Bus> findAll() throws SQLException {
        String sql = "SELECT * FROM bus";
        List<Bus> buses = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt("id"));
                bus.setLicensePlate(rs.getString("license_plate"));
                bus.setBusType(rs.getString("bus_type"));
                bus.setRowSeat(rs.getInt("row_seat"));
                bus.setColSeat(rs.getInt("col_seat"));
                bus.setTotalSeat(rs.getInt("total_seat"));
                bus.setImage(rs.getString("image"));
                buses.add(bus);
            }
        }
        return buses;
    }

    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM bus WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

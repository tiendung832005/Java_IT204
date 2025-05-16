package com.data.session09.dao;

import com.data.session09.model.ScreenRoom;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScreenRoomDAO {
    private final String url = "jdbc:mysql://localhost:3306/session09";
    private final String username = "root";
    private final String password = "12345678";

    public List<ScreenRoom> getAllScreenRooms() {
        List<ScreenRoom> screenRooms = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM screenRooms";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ScreenRoom screenRoom = new ScreenRoom();
                screenRoom.setId(resultSet.getLong("id"));
                screenRoom.setScreenRoomName(resultSet.getString("screenRoomName"));
                screenRoom.setTotalSeat(resultSet.getInt("totalSeat"));
                screenRooms.add(screenRoom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return screenRooms;
    }
}

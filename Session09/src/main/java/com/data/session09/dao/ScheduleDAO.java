package com.data.session09.dao;


import com.data.session09.model.Schedule;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleDAO {
    private final String url = "jdbc:mysql://localhost:3306/session09";
    private final String username = "root";
    private final String password = "12345678";

    public List<Schedule> findAllScheduleByMovie(String movieTitle) {
        List<Schedule> schedules = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM schedules WHERE movieTitle = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, movieTitle);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getLong("id"));
                schedule.setMovieTitle(resultSet.getString("movieTitle"));
                schedule.setShowTime(resultSet.getTimestamp("showTime"));
                schedule.setScreenRoomId(resultSet.getLong("screenRoomId"));
                schedule.setAvailableSeats(resultSet.getInt("availableSeats"));
                schedule.setFormat(resultSet.getString("format"));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }
}

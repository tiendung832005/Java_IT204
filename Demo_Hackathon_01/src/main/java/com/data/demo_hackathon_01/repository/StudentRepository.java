package com.data.demo_hackathon_01.repository;

import com.data.demo_hackathon_01.model.Student;
import com.data.demo_hackathon_01.config.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public List<Student> findAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Student";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setSex(resultSet.getBoolean("sex"));
                student.setBod(resultSet.getString("bod"));
                student.setAvatar(resultSet.getString("avatar"));
                student.setStatus(resultSet.getString("status"));
                students.add(student);
            }
        }
        return students;
    }

    public void save(Student student) throws SQLException {
        String query = "INSERT INTO Student (id, name, email, phone, sex, bod, avatar, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setBoolean(5, student.isSex());
            preparedStatement.setString(6, student.getBod());
            preparedStatement.setString(7, student.getAvatar());
            preparedStatement.setString(8, student.getStatus());
            preparedStatement.executeUpdate();
        }
    }

    public void update(Student student) throws SQLException {
        String query = "UPDATE Student SET name = ?, email = ?, phone = ?, sex = ?, bod = ?, avatar = ?, status = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setBoolean(4, student.isSex());
            preparedStatement.setString(5, student.getBod());
            preparedStatement.setString(6, student.getAvatar());
            preparedStatement.setString(7, student.getStatus());
            preparedStatement.setString(8, student.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void delete(String id) throws SQLException {
        String query = "DELETE FROM Student WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        }
    }
}

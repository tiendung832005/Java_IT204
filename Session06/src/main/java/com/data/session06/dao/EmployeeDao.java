package com.data.session06.dao;

import com.data.session06.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private final String jdbcURL = "jdbc:mysql://localhost:3306";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "password";

    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employees";
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employees (name, birthday, phone, email, salary, position) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employees SET name = ?, birthday = ?, phone = ?, email = ?, salary = ?, position = ? WHERE id = ?";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employees WHERE id = ?";
    private static final String SEARCH_EMPLOYEE_SQL = "SELECT * FROM employees WHERE name LIKE ? OR id = ?";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getDate("birthday"),
                        rs.getString("phone"), rs.getString("email"), rs.getDouble("salary"), rs.getString("position")));
            }
        }
        return employees;
    }

    public void addEmployee(Employee employee) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2, new java.sql.Date(employee.getBirthday().getTime()));
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setString(6, employee.getPosition());
            preparedStatement.executeUpdate();
        }
    }

    public void updateEmployee(Employee employee) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2, new java.sql.Date(employee.getBirthday().getTime()));
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setString(6, employee.getPosition());
            preparedStatement.setInt(7, employee.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<Employee> searchEmployees(String name, int id) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setInt(2, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getDate("birthday"),
                        rs.getString("phone"), rs.getString("email"), rs.getDouble("salary"), rs.getString("position")));
            }
        }
        return employees;
    }
}

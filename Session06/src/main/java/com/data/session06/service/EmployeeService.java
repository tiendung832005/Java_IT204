package com.data.session06.service;


import com.data.session06.dao.EmployeeDao;
import com.data.session06.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private final EmployeeDao employeeDao = new EmployeeDao();

    public List<Employee> getAllEmployees() throws SQLException {
        return employeeDao.getAllEmployees();
    }

    public void addEmployee(Employee employee) throws SQLException {
        employeeDao.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) throws SQLException {
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(int id) throws SQLException {
        employeeDao.deleteEmployee(id);
    }

    public List<Employee> searchEmployees(String name, int id) throws SQLException {
        return employeeDao.searchEmployees(name, id);
    }
}

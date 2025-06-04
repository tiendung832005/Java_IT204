package com.data.session18.repository;

import com.data.session18.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<com.data.session18.entity.Employee> findAll();
}
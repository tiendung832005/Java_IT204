package com.data.session12.repository;

import com.data.session12.model.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class StudentRepository {
    // Simulating a database with an in-memory list
    private List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public void deleteById(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public Student findById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public abstract List<Student> findAll() throws SQLException;
}

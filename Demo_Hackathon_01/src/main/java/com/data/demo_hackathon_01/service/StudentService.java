package com.data.demo_hackathon_01.service;

import com.data.demo_hackathon_01.model.Student;
import com.data.demo_hackathon_01.repository.StudentRepository;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository = new StudentRepository();

    public List<Student> getAllStudents() throws SQLException {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) throws SQLException {
        // Add validation logic here
        studentRepository.save(student);
    }

    public void updateStudent(Student student) throws SQLException {
        if (student.getName() == null || student.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (!student.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (!student.getPhone().matches("^(0[3|5|7|8|9])+([0-9]{8})$")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        studentRepository.update(student);
    }

    public void deleteStudent(String id) throws SQLException {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
        studentRepository.delete(id);
    }
}

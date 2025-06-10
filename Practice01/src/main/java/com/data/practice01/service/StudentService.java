package com.data.practice01.service;

import com.data.practice01.entity.Student;
import com.data.practice01.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public List<Student> getAllStudents(int page, int size) {
        int offset = page * size;
        return studentRepository.findAll(offset, size);
    }

    @Transactional
    public List<Student> searchStudentsByName(String name, int page, int size) {
        int offset = page * size;
        return studentRepository.searchByName(name, offset, size);
    }

    @Transactional
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    @Transactional
    public void deleteStudent(String id) {
        studentRepository.deleteById(Integer.parseInt(id));
    }

    @Transactional
    public Student getStudentById(String id) {
        try {
            int studentId = Integer.parseInt(id);
            return studentRepository.findById(studentId);
        } catch (NumberFormatException e) {
            System.out.println("Invalid student ID: " + id);
            return null;
        }
    }
}
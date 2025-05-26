package com.data.session12.service;

import com.data.session12.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl extends StudentService {

    private final List<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        // Thêm sinh viên mới vào danh sách
        students.add(student);
    }

    @Override
    public void deleteById(int id) {
        // Xóa sinh viên theo ID
        students.removeIf(student -> student.getId() == id);
    }

    @Override
    public Student findById(int id) {
        // Tìm sinh viên theo ID
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> findAll() {
        // Trả về danh sách tất cả sinh viên
        return new ArrayList<>(students);
    }
}
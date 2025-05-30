package com.data.session15.controller;

import com.data.session15.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/students")
    public String getStudents(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("S001", "John Doe", 20, "CS101", "john.doe@example.com", "123 Main St", "1234567890"));
        students.add(new Student("S002", "Jane Smith", 22, "CS102", "jane.smith@example.com", "456 Elm St", "0987654321"));
        students.add(new Student("S003", "Alice Johnson", 19, "CS103", "alice.johnson@example.com", "789 Oak St", "1122334455"));

        model.addAttribute("students", students);
        return "studentList";
    }
}

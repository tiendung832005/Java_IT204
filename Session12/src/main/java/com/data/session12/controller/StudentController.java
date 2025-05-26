package com.data.session12.controller;

import com.data.session12.model.Student;
import com.data.session12.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;


    @GetMapping("list-students")
    public String findAll(Model model) {
        List<Student> students = studentService.findAll();
        return "student_list";
    }

    @GetMapping("/add-student")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add_student";
    }

    @PostMapping("/add-student")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "add_student";
        }
        studentService.save(student);
        return "redirect:/list-students";
    }



    @GetMapping("/edit-student/{id}")
    public String showEditStudentForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "edit_student";
    }

    @PostMapping("/edit-student/{id}")
    public String editStudent(@PathVariable("id") Long id, @Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_student";
        }
        student.setId(Math.toIntExact(id));
        studentService.update(student);
        return "redirect:/list-students";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteById(Math.toIntExact(id));
        return "redirect:/list-students";
    }
}

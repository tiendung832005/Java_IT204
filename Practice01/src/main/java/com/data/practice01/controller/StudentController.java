package com.data.practice01.controller;

import com.cloudinary.Cloudinary;
import com.data.practice01.entity.Course;
import com.data.practice01.entity.Student;
import com.data.practice01.service.CourseService;
import com.data.practice01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;


    @Autowired
    private Cloudinary cloudinary;

    @GetMapping
    public String listStudents(@RequestParam(defaultValue = "0") int page, Model model) {
        List<Student> students = studentService.getAllStudents(page, 5);
        model.addAttribute("students", students);
        model.addAttribute("currentPage", page);
        return "student-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("availableCourses", courseService.getAllCourses());
        return "student-form";
    }

    @PostMapping("/new")
    public String createStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult result,
                                @RequestParam(value = "courseIds", required = false) List<Long> courseIds,
                                @RequestParam(value = "photo", required = false) MultipartFile photo,
                                Model model) throws IOException {

        if (result.hasErrors()) {
                return "student-form";
        }

        if (photo != null && !photo.isEmpty()) {
            Map<String, Object> uploadResult = cloudinary.uploader().upload(photo.getBytes(), new HashMap<>());
            student.setAvatar((String) uploadResult.get("url"));
        }

        if (courseIds != null && !courseIds.isEmpty()) {
            Set<Course> selectedCourses = new HashSet<>(Collections.singleton(courseService.getCourseById(new HashSet<>(courseIds))));
            student.setCourses(selectedCourses);
        } else {
            student.setCourses(new HashSet<>());
        }

        studentService.saveStudent(student);
        return "redirect:/students";
    }



    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("availableCourses", courseService.getAllCourses());
        return "student-form";
    }


    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable("id") String id,
                                @ModelAttribute Student student,
                                @RequestParam("photo") MultipartFile photo) throws IOException {
        if (!photo.isEmpty()) {
            Map<String, Object> uploadResult = cloudinary.uploader().upload(photo.getBytes(), new HashMap<>());
            student.setAvatar((String) uploadResult.get("url"));
        }
        student.setId(id);
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam String name,
                                 @RequestParam(defaultValue = "0") int page,
                                 Model model) {
        List<Student> students = studentService.searchStudentsByName(name, page, 5);
        model.addAttribute("students", students);
        model.addAttribute("currentPage", page);
        model.addAttribute("searchQuery", name);
        return "student-list";
    }
}
package com.data.session07.controller;


import com.data.session07.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private List<Course> courseList = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseList);
        return "listCourse";
    }

    @GetMapping("/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course(null, "", ""));
        return "addCourse";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute Course course) {
        course.setId(nextId++);
        courseList.add(course);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseList.removeIf(course -> course.getId().equals(id));
        return "redirect:/courses";
    }
}

package com.data.practice01.controller;

import com.data.practice01.entity.Course;
import com.data.practice01.repository.CourseRepository;
import com.data.practice01.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "course-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("course", new Course());
        return "course-form";
    }

    @PostMapping("/new")
    public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "course-form";
        }

        List<Course> existingCourses = courseRepository.findAll();
        for (Course existingCourse : existingCourses) {
            if (existingCourse.getName().equalsIgnoreCase(course.getName())) {
                model.addAttribute("errorMessage", "Tên khóa học đã tồn tại: " + course.getName());
                return "course-form";
            }
        }

        courseRepository.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Set<Long> id, Model model) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            model.addAttribute("course", course);
            return "course-form";
        }
        return "redirect:/courses";
    }

    @PostMapping("/edit/{id}")
    public String updateCourse(@PathVariable("id") int id, @Valid @ModelAttribute("course") Course course, BindingResult result) {
        if (result.hasErrors()) {
            return "course-form";
        }
        course.setId(id);
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }
}

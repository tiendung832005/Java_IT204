package com.data.practice01.service;

import com.data.practice01.entity.Course;
import com.data.practice01.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Set<Long> id) {
        return courseRepository.findById(id);
    }

    @Transactional
    public void saveCourse(Course course) {
        List<Course> existingCourses = courseRepository.findAll();
        for (Course existingCourse : existingCourses) {
            if (existingCourse.getName().equalsIgnoreCase(course.getName())) {
                System.out.println("Tên khóa học đã tồn tại: " + course.getName());
                return;
            }
        }
        courseRepository.save(course);
    }

    @Transactional
    public void deleteCourse(int id) {
        if (!courseRepository.hasStudents(id)) {
            courseRepository.deleteById(id);
        }
    }
}
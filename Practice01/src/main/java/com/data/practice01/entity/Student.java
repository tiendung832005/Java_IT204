package com.data.practice01.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Size(min = 5, max = 5)
    @Column(length = 5, nullable = false)
    private String id;

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 200)
    private String name;

    @NotNull
    @Email
    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "Email không được để trống")
    private String email;

    @NotNull
    @Size(max = 15)
    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Số điện thoại không hợp lệ")
    private String phone;

    @NotNull
    @Column(nullable = false)
    private boolean sex;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date bod;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "student_course", // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "student_id"), // Khóa ngoại tới Student
            inverseJoinColumns = @JoinColumn(name = "course_id") // Khóa ngoại tới Course
    )
    private Set<Course> courses = new HashSet<>();

    @Column(columnDefinition = "TEXT")
    private String avatar;

    @NotNull
    @Column(nullable = false, columnDefinition = "BIT COMMENT 'true: Dang hoc, false: Nghi hoc'")
    private boolean status;

    // Constructors
    public Student() {
        this.courses = new HashSet<>();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBod() {
        return bod;
    }

    public void setBod(Date bod) {
        this.bod = bod;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Helper methods để quản lý relationship
    public void addCourse(Course course) {
        this.courses.add(course);
        course.getStudents().add(this);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
        course.getStudents().remove(this);
    }
}
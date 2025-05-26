package com.data.session12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("")
public class DemoController {
    @GetMapping("student")
    public String showStudentPage() {
        return "student_list";
    }
}

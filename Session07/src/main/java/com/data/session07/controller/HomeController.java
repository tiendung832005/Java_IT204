package com.data.session07.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class HomeController {
    @RequestMapping("/home")
    @ResponseBody
    public String home() {
        return "Hello, đây là trang home";
    }

    @RequestMapping("/greet")
    @ResponseBody
    public String greet(@RequestParam String name){
        return "Hello, " + name;
    }
}

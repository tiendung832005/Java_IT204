package com.data.session07.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ErrorController {
    @RequestMapping("/error")
    public ModelAndView handleError(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Đã xảy ra lỗi");
        return modelAndView;
    }
}

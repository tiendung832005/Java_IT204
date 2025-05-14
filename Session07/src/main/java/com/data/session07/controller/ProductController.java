package com.data.session07.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Component
@Controller
@RequestMapping("/product")
public class ProductController {

    // @RequestMapping(value = "product", method = RequestMethod.GET)
    @RequestMapping(value = "product.jsp", method = RequestMethod.GET)
    public ModelAndView getAll(){
//        ModelAndView, ModelView, Model
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("data", "Hello, đây là trang product");
        return modelAndView;
    }
}

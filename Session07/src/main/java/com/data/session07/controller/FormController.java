package com.data.session07.controller;

import com.data.session07.model.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {
    private final List<Feedback> feedbackList = new ArrayList<>();

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("feedback", new Feedback());
        return "form";
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute Feedback feedback,Model model){
        if (feedback.getName().isEmpty() || feedback.getContent().isEmpty()){
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin");
            return "form";
        } else {
            feedbackList.add(feedback);
            model.addAttribute("feedbackList", feedbackList);
            return "success";
        }
    }
}

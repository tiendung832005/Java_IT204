package com.data.session11.controller;

import com.data.session11.dto.RegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationDTO", new RegistrationDTO());
        return "registrationForm";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("registrationDTO") RegistrationDTO registrationDTO,
                                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registrationForm";
        }
        model.addAttribute("message", "Đăng ký thành công!");
        return "registrationSuccess";
    }
}

package com.data.session11.controller;


import com.data.session11.dto.RegisterDTO;
import com.data.session11.validator.ValidationGroups;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationDTO", new RegisterDTO());
        return "registrationForm";
    }

    @PostMapping("/register")
    public String processRegistration(@Validated({ValidationGroups.Admin.class, ValidationGroups.User.class})
                                      @ModelAttribute("registrationDTO") RegisterDTO registrationDTO,
                                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registrationForm";
        }
        model.addAttribute("message", "Đăng ký thành công!");
        return "registrationSuccess";
    }
}
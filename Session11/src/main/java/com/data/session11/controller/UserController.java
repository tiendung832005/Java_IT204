package com.data.session11.controller;

import com.data.session11.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/user-form")
    public String showForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "userForm";
    }

    @PostMapping("/user-save")
    public String saveUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "userForm";
        }

        model.addAttribute("message", "User saved successfully!");
        return "userSuccess";
    }
}

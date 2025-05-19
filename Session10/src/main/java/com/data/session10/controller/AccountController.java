package com.data.session10.controller;

import com.data.session10.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           Model model) {

        Account account = new Account(username, password, email);

        model.addAttribute("message", "Registration successful!");

        return "registerSuccess";
    }
}

package com.data.session14.controller;

import com.data.session14.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class RegistrationController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/register")
    public String showRegistrationForm(HttpSession session, Model model) {
        Locale locale = (Locale) session.getAttribute("locale");
        if (locale == null) {
            locale = Locale.ENGLISH; // Default language
            session.setAttribute("locale", locale);
        }
        model.addAttribute("locale", locale);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password,
                               @RequestParam String confirmPassword, @RequestParam String email,
                               HttpSession session, Model model) {
        Locale locale = (Locale) session.getAttribute("locale");
        if (locale == null) {
            locale = Locale.ENGLISH;
        }

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            model.addAttribute("message", messageSource.getMessage("error.empty.fields", null, locale));
            return "register";
        }

        if (!password.equals(confirmPassword)) {
            model.addAttribute("message", messageSource.getMessage("error.password.mismatch", null, locale));
            return "register";
        }

        User user = new User(username, password, email);
        model.addAttribute("message", messageSource.getMessage("success.registration", null, locale));
        return "register";
    }

    @GetMapping("/change-language")
    public String changeLanguage(@RequestParam String lang, HttpSession session) {
        Locale locale = "vi".equals(lang) ? new Locale("vi") : Locale.ENGLISH;
        session.setAttribute("locale", locale);
        return "redirect:/register";
    }
}

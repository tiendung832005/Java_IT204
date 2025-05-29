package com.data.session14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class LanguageController {

    @GetMapping("/")
    public String showHomePage(HttpSession session, Model model) {
        Locale locale = (Locale) session.getAttribute("locale");
        if (locale == null) {
            locale = Locale.ENGLISH;
            session.setAttribute("locale", locale);
        }
        model.addAttribute("locale", locale);
        return "home";
    }

    @GetMapping("/change-language")
    public String changeLanguage(@RequestParam String lang, HttpSession session) {
        Locale locale = "vi".equals(lang) ? new Locale("vi") : Locale.ENGLISH;
        session.setAttribute("locale", locale);
        return "redirect:/";
    }
}
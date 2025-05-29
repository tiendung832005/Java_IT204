package com.data.session14.controller;


import com.data.session14.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        String rememberedUsername = "";
        String rememberedPassword = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    rememberedUsername = cookie.getValue();
                }
                if ("password".equals(cookie.getName())) {
                    rememberedPassword = cookie.getValue();
                }
            }
        }
        model.addAttribute("rememberedUsername", rememberedUsername);
        model.addAttribute("rememberedPassword", rememberedPassword);
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password,
                            @RequestParam(required = false) String rememberMe,
                            HttpSession session, HttpServletResponse response, Model model) {

        if ("admin".equals(username) && "password".equals(password)) {
            session.setAttribute("user", new User(username, password));

            if ("on".equals(rememberMe)) {
                Cookie usernameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);
                usernameCookie.setMaxAge(60 * 60 * 24 * 7); // 7 days
                passwordCookie.setMaxAge(60 * 60 * 24 * 7); // 7 days
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }

            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session, HttpServletResponse response) {
        session.invalidate();

        Cookie usernameCookie = new Cookie("username", null);
        Cookie passwordCookie = new Cookie("password", null);
        usernameCookie.setMaxAge(0);
        passwordCookie.setMaxAge(0);
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);

        return "redirect:/login";
    }
}
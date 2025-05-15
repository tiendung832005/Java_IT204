package com.data.session08.controller;

import com.data.session08.model.Bai8.Seeds;
import com.data.session08.model.Bai8.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("loggedInUser")
public class GameController {

    private List<User> users = new ArrayList<>();
    private List<Seeds> seeds = new ArrayList<>();

    public GameController() {
        seeds.add(new Seeds() {{
            setId(1);
            setSeedsName("Wheat");
            setPrice(50);
            setImageUrl("/images/wheat.jpg");
        }});
        seeds.add(new Seeds() {{
            setId(2);
            setSeedsName("Corn");
            setPrice(75);
            setImageUrl("/images/corn.jpg");
        }});
        seeds.add(new Seeds() {{
            setId(3);
            setSeedsName("Rice");
            setPrice(100);
            setImageUrl("/images/rice.jpg");
        }});
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        users.add(user);
        model.addAttribute("message", "Registration successful! Please log in.");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                model.addAttribute("loggedInUser", u);
                return "redirect:/home";
            }
        }
        model.addAttribute("message", "Invalid username or password.");
        return "login";
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        model.addAttribute("seeds", seeds);
        return "shop";
    }

    @GetMapping("/home")
    public String showHome(@SessionAttribute(value = "loggedInUser", required = false) User loggedInUser) {
        if (loggedInUser == null) {
            return "redirect:/register";
        }
        return "home";
    }


}

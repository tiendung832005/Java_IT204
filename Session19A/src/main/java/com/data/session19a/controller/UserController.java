package com.data.session19a.controller;

import com.data.session19a.entity.User;
import com.data.session19a.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String listUsers(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "5") int size,
                            Model model) {
        List<User> users = userRepository.findUsers(page, size);
        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        return "user-list";
    }

    @PostMapping("/update-status")
    public String updateUserStatus(@RequestParam Long userId, @RequestParam boolean isActive) {
        userRepository.updateUserStatus(userId, isActive);
        return "redirect:/users";
    }
}
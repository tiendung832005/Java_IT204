package com.data.session17.Controller;

import com.data.session17.entity.User;
import com.data.session17.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String listUsers(HttpSession session, Model model,
                            @RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "10") int pageSize,
                            @RequestParam(defaultValue = "") String filter) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        List<User> users = userRepository.findUsers(page, pageSize, filter);
        long totalUsers = userRepository.countUsers(filter);

        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("filter", filter);
        return "admin/users";
    }

    @PostMapping("/lock/{id}")
    public String lockUser(@PathVariable int id, HttpSession session) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        userRepository.updateUserStatus(id, "locked");
        return "redirect:/admin/users";
    }

    @PostMapping("/unlock/{id}")
    public String unlockUser(@PathVariable int id, HttpSession session) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        userRepository.updateUserStatus(id, "active");
        return "redirect:/admin/users";
    }

    private boolean isAdmin(HttpSession session) {
        String role = (String) session.getAttribute("role");
        return role != null && role.equals("admin");
    }
}
package com.data.session17.Controller;


import com.data.session17.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/admin")
    public String showAdminDashboard(HttpSession session, Model model) {
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            return "redirect:/login";
        }

        model.addAttribute("userCount", adminRepository.countUsers());
        model.addAttribute("productCount", adminRepository.countProducts());
        model.addAttribute("orderCount", adminRepository.countOrders());
        model.addAttribute("monthlyRevenue", adminRepository.calculateRevenueByMonth());
        model.addAttribute("yearlyRevenue", adminRepository.calculateRevenueByYear());
        return "admin/dashboard";
    }

    @GetMapping("/admin/products")
    public String manageProducts(HttpSession session) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }
        return "admin/products";
    }

    @GetMapping("/admin/users")
    public String manageUsers(HttpSession session) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }
        return "admin/users";
    }

    @GetMapping("/admin/orders")
    public String manageOrders(HttpSession session) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }
        return "admin/orders";
    }

    private boolean isAdmin(HttpSession session) {
        String role = (String) session.getAttribute("role");
        return role != null && role.equals("admin");
    }
}
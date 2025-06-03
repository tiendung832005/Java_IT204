package com.data.session17.Controller;

import com.data.session17.entity.Customer;
import com.data.session17.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "register";
    }

    @PostMapping("/register")
    public String registerCustomer(@Validated Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        customerService.saveCustomer(customer);
        model.addAttribute("message", "Đăng ký thành công!");
        return "register";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "login";
    }

    @PostMapping("/login")
    public String loginCustomer(@Validated Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login";
        }

        Customer existingCustomer = customerService.findByUsernameAndPassword(customer.getUsername(), customer.getPassword());
        if (existingCustomer == null) {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            return "login";
        }

        if ("ADMIN".equals(existingCustomer.getRole())) {
            return "redirect:/admin";
        } else if ("USER".equals(existingCustomer.getRole())) {
            return "redirect:/home";
        }

        model.addAttribute("error", "Vai trò không hợp lệ!");
        return "login";
    }
}

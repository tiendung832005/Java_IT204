package com.data.session09.Controller;

import com.data.session09.Connect.Connection;
import com.data.session09.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private Connection customerRepository;

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {
        Customer customer = customerRepository.findByUsername(username);
        if (customer != null && "1234".equals(password)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}


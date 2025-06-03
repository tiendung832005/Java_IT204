package com.data.session17.Controller;


import com.data.session17.entity.Customer;
import com.data.session17.entity.Order;
import com.data.session17.repository.CustomerRepository;
import com.data.session17.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/profile")
    public String showProfile(HttpSession session, Model model,
                              @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int pageSize) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }

        Customer customer = customerRepository.findById(customerId);
        List<Order> orders = orderRepository.findOrdersByCustomerId(customerId, page, pageSize);

        model.addAttribute("customer", customer);
        model.addAttribute("orders", orders);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        return "profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute Customer customer, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }

        customer.setId(customerId);
        customerRepository.updateCustomer(customer);
        return "redirect:/profile";
    }

    @PostMapping("/cancel-order")
    public String cancelOrder(@RequestParam int orderId, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }

        orderRepository.deleteOrderById(orderId);
        return "redirect:/profile";
    }
}

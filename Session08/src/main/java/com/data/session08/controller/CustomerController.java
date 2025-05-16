package com.data.session08.controller;


import com.data.session08.model.Customer;
import com.data.session08.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("customer")
    public String findAll(Model model) {
        List<Customer> customers = customerService.findAll();
        System.out.println("Size: " + customers.size());
        // model truyen du lieu ra view
        model.addAttribute("customers", customers);

        return "customer"; // file customer.jsp
    }

    @GetMapping("customer/{id}")
    public String findById(Model model,
                           @PathVariable Integer id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);

        return "customer_detail"; // file customer_detail.jsp
    }

    @GetMapping("customer-add")
    public String add() {
        return "customer_add"; // file customer_add.jsp
    }

    @PostMapping("customer-save")
    public String save(@RequestParam String fullName,
                       @RequestParam String email) {
        Customer customer = new Customer();
        customer.setFullName(fullName);
        customer.setEmail(email);

        boolean result = customerService.save(customer);

        if (!result) {
            return "customer_add";
        } else {
            return "redirect:/customer";
        }
    }
}

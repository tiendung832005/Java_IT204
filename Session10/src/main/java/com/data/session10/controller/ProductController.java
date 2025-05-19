package com.data.session10.controller;

import com.data.session10.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("price") double price,
                             @RequestParam("description") String description,
                             Model model) {

        Product product = new Product(name, price, description);

        model.addAttribute("product", product);

        return "productResult";
    }
}

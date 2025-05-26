package com.data.session12.controller;


import com.data.session12.model.Product;
import com.data.session12.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService = new ProductService();

    @GetMapping
    public String listProducts(Model model) throws SQLException {
        model.addAttribute("products", productService.findAll());
        return "product_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") Product product) throws SQLException {
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) throws SQLException {
        model.addAttribute("product", productService.findById(id));
        return "product_form";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable int id, @Valid @ModelAttribute("product") Product product) throws SQLException {
        product.setId(id);
        productService.update(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) throws SQLException {
        productService.deleteById(id);
        return "redirect:/products";
    }
}

package com.data.session14.controller;

import com.data.session14.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String showProductForm(Model model, HttpServletRequest request) {
        List<Product> products = getProductsFromCookies(request);
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(@RequestParam String name, @RequestParam double price, HttpServletResponse response) {
        Product product = new Product(name, price);
        Cookie cookie = new Cookie("product_" + name, name + ":" + price);
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        return "redirect:/products";
    }

    @GetMapping("/products/delete")
    public String deleteProduct(@RequestParam String name, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("product_" + name)) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        return "redirect:/products";
    }

    private List<Product> getProductsFromCookies(HttpServletRequest request) {
        List<Product> products = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().startsWith("product_")) {
                    String[] parts = cookie.getValue().split(":");
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    products.add(new Product(name, price));
                }
            }
        }
        return products;
    }
}
package com.data.session14.controller;


import com.data.session14.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String showCart(HttpSession session, HttpServletRequest request, Model model) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        List<Product> products = getProductsFromCookies(request);

        model.addAttribute("cart", cart);
        model.addAttribute("products", products);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam String name, @RequestParam int quantity, HttpSession session, HttpServletResponse response) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(new Product(name, quantity));
        session.setAttribute("cart", cart);

        // Save product information in cookies
        Cookie cookie = new Cookie("product_" + name, name + ":" + quantity);
        cookie.setMaxAge(60 * 60 );
        response.addCookie(cookie);

        return "redirect:/cart";
    }

    @GetMapping("/cart/delete")
    public String deleteFromCart(@RequestParam String name, HttpSession session) {
        // Remove product from session cart
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(product -> product.getName().equals(name));
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart";
    }

    private List<Product> getProductsFromCookies(HttpServletRequest request) {
        List<Product> products = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().startsWith("product_")) {
                    String[] parts = cookie.getValue().split(":");
                    String name = parts[0];
                    int quantity = Integer.parseInt(parts[1]);
                    products.add(new Product(name, quantity));
                }
            }
        }
        return products;
    }
}

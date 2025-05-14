package com.data.session07.controller;


import com.data.session07.model.CartItem;
import com.data.session07.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {

    private List<Product> productList = new ArrayList<>();
    private List<CartItem> cart = new ArrayList<>();

    public ListController() {
        productList.add(new Product(1L, "Laptop", 1200.0, 10, "High-performance laptop", "https://via.placeholder.com/150"));
        productList.add(new Product(2L, "Smartphone", 800.0, 20, "Latest model smartphone", "https://via.placeholder.com/150"));
        productList.add(new Product(3L, "Headphones", 150.0, 50, "Noise-cancelling headphones", "https://via.placeholder.com/150"));
    }

    @RequestMapping("/products")
    public String showProductList(Model model) {
        model.addAttribute("products", productList);
        return "product_list";
    }

    @RequestMapping("/add-to-cart")
    public String addToCart(@RequestParam("id") Long id, @RequestParam("quantity") int quantity, Model model) {
        if (quantity <= 0) {
            model.addAttribute("error", "Quantity must be greater than 0.");
            return "redirect:/products";
        }

        Product product = productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (product != null) {
            CartItem existingItem = cart.stream()
                    .filter(item -> item.getProduct().getId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (existingItem != null) {
                existingItem.setQuantity(existingItem.getQuantity() + quantity);
            } else {
                cart.add(new CartItem(product, quantity));
            }
        }

        return "redirect:/cart";
    }

    @RequestMapping("/cart")
    public String showCart(Model model) {
        double total = cart.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "cart";
    }

    @RequestMapping("/increase-quantity")
    public String increaseQuantity(@RequestParam("id") Long id) {
        cart.stream()
                .filter(item -> item.getProduct().getId().equals(id))
                .findFirst()
                .ifPresent(item -> item.setQuantity(item.getQuantity() + 1));
        return "redirect:/cart";
    }

    @RequestMapping("/decrease-quantity")
    public String decreaseQuantity(@RequestParam("id") Long id) {
        cart.stream()
                .filter(item -> item.getProduct().getId().equals(id))
                .findFirst()
                .ifPresent(item -> {
                    if (item.getQuantity() > 1) {
                        item.setQuantity(item.getQuantity() - 1);
                    } else {
                        cart.remove(item);
                    }
                });
        return "redirect:/cart";
    }

    @RequestMapping("/remove-from-cart")
    public String removeFromCart(@RequestParam("id") Long id) {
        cart.removeIf(item -> item.getProduct().getId().equals(id));
        return "redirect:/cart";
    }
}

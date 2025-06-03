package com.data.session17.Controller;

import com.data.session17.entity.ProductCart;
import com.data.session17.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam int productId, @RequestParam int quantity, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }

        ProductCart existingCartItem = cartRepository.findCartItem(customerId, productId);
        if (existingCartItem != null) {
            existingCartItem.equals(existingCartItem.getQuantity() + quantity);
            cartRepository.saveOrUpdateCartItem(existingCartItem);
        } else {
            ProductCart newCartItem = new ProductCart();
            newCartItem.setCustomerId(customerId);
            newCartItem.setProductId(productId);
            newCartItem.equals(quantity);
            cartRepository.saveOrUpdateCartItem(newCartItem);
        }

        return "redirect:/product?id=" + productId;
    }

    @GetMapping("/cart")
    public String showCart(HttpSession session, Model model) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }

        List<ProductCart> cartItems = cartRepository.findCartItemsByCustomerId(customerId);
        double totalPrice = cartItems.stream()
                .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice())
                .sum();

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }

    @PostMapping("/update-cart")
    public String updateCartItem(@RequestParam int cartId, @RequestParam int quantity, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }

        ProductCart cartItem = cartRepository.findCartItemById(cartId);
        if (cartItem != null && cartItem.getCustomerId() == customerId) {
            cartItem.setQuantity(quantity);
            cartRepository.saveOrUpdateCartItem(cartItem);
        }

        return "redirect:/cart";
    }

    @PostMapping("/delete-cart-item")
    public String deleteCartItem(@RequestParam int cartId, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }

        ProductCart cartItem = cartRepository.findCartItemById(cartId);
        if (cartItem != null && cartItem.getCustomerId() == customerId) {
            cartRepository.deleteCartItem(cartItem);
        }

        return "redirect:/cart";
    }
}

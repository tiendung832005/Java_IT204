package com.data.session17.Controller;


import com.data.session17.entity.Order;
import com.data.session17.repository.CartRepository;
import com.data.session17.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class OrderController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/checkout")
    public String showCheckoutForm(HttpSession session, Model model) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }

        double totalMoney = cartRepository.findCartItemsByCustomerId(customerId).stream()
                .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice())
                .sum();

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setTotalMoney(totalMoney);
        model.addAttribute("order", order);
        return "checkout";
    }

    @PostMapping("/checkout")
    public String processCheckout(Order order, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }

        order.setCustomerId(customerId);
        order.setStatus("Pending");
        orderRepository.saveOrder(order);

        return "redirect:/order-success";
    }
}

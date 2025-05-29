package com.data.session14.controller;


import com.data.session14.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String showOrders(HttpSession session, Model model) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<>();
        }
        model.addAttribute("orders", orders);
        return "orders";
    }

    @PostMapping("/orders/add")
    public String addOrder(@RequestParam String orderId, @RequestParam String productName, @RequestParam int quantity, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(new Order(orderId, productName, quantity));
        session.setAttribute("orders", orders);
        return "redirect:/orders";
    }

    @PostMapping("/orders/edit")
    public String editOrder(@RequestParam String orderId, @RequestParam String productName, @RequestParam int quantity, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders != null) {
            for (Order order : orders) {
                if (order.getOrderId().equals(orderId)) {
                    order.setProductName(productName);
                    order.setQuantity(quantity);
                    break;
                }
            }
            session.setAttribute("orders", orders);
        }
        return "redirect:/orders";
    }

    @GetMapping("/orders/delete")
    public String deleteOrder(@RequestParam String orderId, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders != null) {
            orders.removeIf(order -> order.getOrderId().equals(orderId));
            session.setAttribute("orders", orders);
        }
        return "redirect:/orders";
    }

    @PostMapping("/order/place")
    public String placeOrder(@RequestParam String username, @RequestParam String productName,
                             @RequestParam int quantity, HttpSession session, Model model) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(new Order(username, productName, quantity));
        session.setAttribute("orders", orders);

        model.addAttribute("message", "Order placed successfully!");
        return "order";
    }

    @GetMapping("/order/view")
    public String viewOrders(HttpSession session, Model model) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<>();
        }
        model.addAttribute("orders", orders);
        return "viewOrders";
    }
}

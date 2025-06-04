package com.data.session17.Controller;


import com.data.session17.entity.Order;
import com.data.session17.repository.CartRepository;
import com.data.session17.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

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

    @GetMapping
    public String listOrders(HttpSession session, Model model,
                             @RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "10") int pageSize,
                             @RequestParam(required = false) String recipientName,
                             @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date orderDate,
                             @RequestParam(required = false) String status) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        List<Order> orders = orderRepository.findOrders(page, pageSize, recipientName, orderDate, status);
        long totalOrders = orderRepository.countOrders(recipientName, orderDate, status);

        model.addAttribute("orders", orders);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalOrders", totalOrders);
        model.addAttribute("recipientName", recipientName);
        model.addAttribute("orderDate", orderDate);
        model.addAttribute("status", status);
        return "admin/orders";
    }

    @PostMapping("/update-status/{id}")
    public String updateOrderStatus(@PathVariable int id, @RequestParam String status, HttpSession session) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        orderRepository.updateOrderStatus(id, status);
        return "redirect:/admin/orders";
    }

    @PostMapping("/delete/{id}")
    public String deleteOrder(@PathVariable int id, HttpSession session) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        orderRepository.deleteOrder(id);
        return "redirect:/admin/orders";
    }

    private boolean isAdmin(HttpSession session) {
        String role = (String) session.getAttribute("role");
        return role != null && role.equals("admin");
    }
}

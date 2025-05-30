package com.data.session15.controller;


import com.data.session15.model.Cart;
import com.data.session15.model.Order;
import com.data.session15.model.OrderDetail;
import com.data.session15.model.Product;
import com.data.session15.service.CartService;
import com.data.session15.service.OrderService;
import com.data.session15.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {

    private final CartService cartService;
    private final ProductService productService;
    private final OrderService orderService;

    public CartController(CartService cartService, ProductService productService, OrderService orderService) {
        this.cartService = cartService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/checkout")
    public String checkout(@RequestParam int idUser, Model model) {
        List<Cart> cartItems = cartService.getCartByUserId(idUser);
        List<Product> products = productService.findAll();

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("products", products);
        model.addAttribute("order", new Order());
        return "checkout";
    }

    @PostMapping("/place-order")
    public String placeOrder(@ModelAttribute("order") Order order, @RequestParam int idUser) {
        int orderId = orderService.saveOrder(order);

        List<Cart> cartItems = cartService.getCartByUserId(idUser);
        List<Product> products = productService.findAll();

        cartItems.forEach(cart -> {
            Product product = products.stream()
                    .filter(p -> p.getId() == cart.getIdProduct())
                    .findFirst()
                    .orElse(null);

            if (product != null) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(orderId);
                orderDetail.setProductId(cart.getIdProduct());
                orderDetail.setQuantity(cart.getQuantity());
                orderDetail.setCurrentPrice(product.getPrice());
                orderService.saveOrderDetail(orderDetail);
            }
        });

        cartService.clearCart(idUser);
        return "redirect:/order-success";
    }
}

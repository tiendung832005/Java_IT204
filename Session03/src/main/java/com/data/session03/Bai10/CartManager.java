package com.data.session03.Bai10;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private List<Product> cart = new ArrayList<>();

    public void addProduct(Product product) {
        boolean exists = cart.stream().anyMatch(p -> p.getId() == product.getId());
        if (!exists) {
            cart.add(product);
        }
    }

    public List<Product> getCart() {
        return cart;
    }

    public void removeProduct(int id) {
        cart.removeIf(p -> p.getId() == id);
    }

    public double getTotalPrice() {
        return cart.stream().mapToDouble(Product::getPrice).sum();
    }
}


package com.data.session05.view;

import com.data.session05.model.Product;

import java.util.List;

public class ProductView {
    public void displayProducts(List<Product> products) {
        System.out.println("Product List:");
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() +
                    ", Price: " + product.getPrice() + ", Description: " + product.getDescription());
        }
    }
}

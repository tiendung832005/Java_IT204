package com.data.session05.controller;

import com.data.session05.model.Product;
import com.data.session05.view.ProductView;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private List<Product> products = new ArrayList<>();
    private ProductView view = new ProductView();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showAllProducts() {
        view.displayProducts(products);
    }
}

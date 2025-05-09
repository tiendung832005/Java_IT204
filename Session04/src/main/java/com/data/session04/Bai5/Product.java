package com.data.session04.Bai5;

public class Product {
    private int id;
    private String productName;
    private double price;
    private String description;

    public Product(int id, String productName, double price, String description) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
}


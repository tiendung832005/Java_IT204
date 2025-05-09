package com.data.session04.Bai1;

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

    public int getId() { return id; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }

    public void setId(int id) { this.id = id; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setPrice(double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
}


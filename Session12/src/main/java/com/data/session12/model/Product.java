package com.data.session12.model;




import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Product {
    private int id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String name;

    @Min(value = 1, message = "Giá phải lớn hơn 0")
    private double price;

    @Min(value = 0, message = "Số lượng không được âm")
    private int quantity;

    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

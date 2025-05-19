package com.data.session10.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.data.session10.model.Bai10.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductManagementController {

    private final Cloudinary cloudinary;

    public ProductManagementController() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "your-cloud-name");
        config.put("api_key", "your-api-key");
        config.put("api_secret", "your-api-secret");
        this.cloudinary = new Cloudinary(config);
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("price") double price,
                             @RequestParam("stock") int stock,
                             @RequestParam("image") MultipartFile image,
                             Model model) {
        try {
            Map uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
            String imageUrl = (String) uploadResult.get("url");

            Product product = new Product(0, name, price, stock, imageUrl);


            model.addAttribute("product", product);
            model.addAttribute("message", "Product added successfully!");
        } catch (IOException e) {
            model.addAttribute("message", "Failed to upload image: " + e.getMessage());
        }
        return "productResult";
    }

    @PostMapping("/editProduct")
    public String editProduct(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("price") double price,
                              @RequestParam("stock") int stock,
                              Model model) {

        model.addAttribute("message", "Product updated successfully!");
        return "productResult";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") int id, Model model) {
        model.addAttribute("message", "Product deleted successfully!");
        return "productResult";
    }
}

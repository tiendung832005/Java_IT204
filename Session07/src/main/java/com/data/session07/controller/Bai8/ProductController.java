package com.data.session07.controller.Bai8;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @RequestMapping("/products/{category}")
    public String getProductsByCategory(
            @PathVariable("category") String category,
            @MatrixVariable(pathVar = "category", value = "color", required = false) String color,
            @MatrixVariable(pathVar = "category", value = "size", required = false) String size,
            Model model) {

        List<String> products = new ArrayList<>();
        if ("clothing".equals(category)) {
            if ("red".equals(color) && "M".equals(size)) {
                products.add("Red Shirt - Size M");
            } else if ("blue".equals(color)) {
                products.add("Blue Jeans");
            } else {
                products.add("Generic Clothing Item");
            }
        } else if ("electronics".equals(category)) {
            if ("black".equals(color)) {
                products.add("Black Smartphone");
            } else {
                products.add("Generic Electronic Item");
            }
        }

        model.addAttribute("category", category);
        model.addAttribute("color", color);
        model.addAttribute("size", size);
        model.addAttribute("products", products);

        return "product_list";
    }
}

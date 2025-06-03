package com.data.session17.Controller;

import com.data.session17.entity.Product;
import com.data.session17.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/home")
    public String showHomePage(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "10") int pageSize,
                               Model model) {
        List<Product> products = productRepository.getProducts(page, pageSize);
        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        return "home";
    }

    @GetMapping("/product")
    public String showProductDetail(@RequestParam int id, Model model) {
        Product product = productRepository.getProductById(id);
        model.addAttribute("product", product);
        return "product-detail";
    }
}
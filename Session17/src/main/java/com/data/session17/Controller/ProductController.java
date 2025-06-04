package com.data.session17.Controller;


import com.data.session17.entity.Product;
import com.data.session17.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String listProducts(HttpSession session, Model model,
                               @RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "10") int pageSize,
                               @RequestParam(defaultValue = "") String filter) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        List<Product> products = productRepository.findProducts(page, pageSize, filter);
        long totalProducts = productRepository.countProducts(filter);

        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalProducts", totalProducts);
        model.addAttribute("filter", filter);
        return "admin/products";
    }

    @GetMapping("/create")
    public String showCreateForm(HttpSession session, Model model) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        model.addAttribute("product", new Product());
        return "admin/product-form";
    }

    @PostMapping("/create")
    public String createProduct(@Validated @ModelAttribute Product product, BindingResult result,
                                @RequestParam("imageFile") MultipartFile imageFile, HttpSession session) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        if (result.hasErrors()) {
            return "admin/product-form";
        }

        // Upload image to cloud and set URL
        String imageUrl = uploadImageToCloud(imageFile);
        product.setImage(imageUrl);

        productRepository.saveOrUpdate(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, HttpSession session, Model model) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "admin/product-form";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable int id, @Validated @ModelAttribute Product product, BindingResult result,
                              @RequestParam("imageFile") MultipartFile imageFile, HttpSession session) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        if (result.hasErrors()) {
            return "admin/product-form";
        }

        // Upload image to cloud if a new image is provided
        if (!imageFile.isEmpty()) {
            String imageUrl = uploadImageToCloud(imageFile);
            product.setImage(imageUrl);
        }

        productRepository.saveOrUpdate(product);
        return "redirect:/admin/products";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, HttpSession session) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        productRepository.deleteById(id);
        return "redirect:/admin/products";
    }

    private boolean isAdmin(HttpSession session) {
        String role = (String) session.getAttribute("role");
        return role != null && role.equals("admin");
    }

    private String uploadImageToCloud(MultipartFile imageFile) {
        // Implement cloud upload logic here (e.g., AWS S3, Google Cloud Storage)
        return "https://cloud-storage-url/" + imageFile.getOriginalFilename();
    }
}

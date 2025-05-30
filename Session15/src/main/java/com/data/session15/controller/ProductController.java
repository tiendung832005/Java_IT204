package com.data.session15.controller;


import com.data.session15.dto.ProductDTO;
import com.data.session15.model.Cart;
import com.data.session15.model.Product;
import com.data.session15.model.Review;
import com.data.session15.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// show dữ liệu
// delete
// add
@Controller
public class ProductController {
    private ProductService productService;

    private List<Product> products;

    public ProductController() {
        products = new ArrayList<>();
        products.add(new Product("1", "Laptop", 1500));
        products.add(new Product("3", "Smartphone", 800));
        products.add(new Product("2", "Tablet", 600));
    }

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("list-product")
    public String getAll(Model model) {
//        String fullName = "Nguyen Ngoc";
//        String address = "HN";
//
//        productDTOS = new ArrayList<>();
//        productDTOS.add(new ProductDTO(1, "Car", 1100));
//        productDTOS.add(new ProductDTO(2, "Hat", 1600));
//
//        model.addAttribute("fullName", fullName);
//        model.addAttribute("address", address);
//        model.addAttribute("productDTOS", productDTOS);

        List<Product> products = productService.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        products.forEach(product -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setProductName(product.getProductName());
            productDTO.setPrice(product.getPrice());

            productDTOS.add(productDTO);
        });

        model.addAttribute("products", productDTOS);

        return "product_list";
    }

    @GetMapping("product-add")
    public String add(Model model) {
        ProductDTO productDTO = new ProductDTO();
        model.addAttribute("productDTO", productDTO);

        return "product_add";
    }

    @PostMapping("product-save")
    public String save(@ModelAttribute("productDTO") ProductDTO productDTO) {
        Product product = new Product("1", "Laptop", 1500);
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());

        productService.save(product);

        return "redirect:/list-product";
    }

    @GetMapping("product-delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);

        return "redirect:/list-product";
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam(value = "query", required = false) String query, Model model) {
        if (query == null || query.trim().isEmpty()) {
            model.addAttribute("error", "Search field cannot be empty");
            return "search";
        }

        List<Product> results = products.stream()
                .filter(product -> product.getProductName().toLowerCase().contains(query.toLowerCase())
                        || product.getId().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());

        model.addAttribute("results", results);
        model.addAttribute("query", query);
        return "search";
    }

    private List<Review> reviews;


    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable int id, Model model) {
        Product product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        List<Review> productReviews = reviews.stream()
                .filter(r -> r.getIdProduct() == id)
                .toList();

        model.addAttribute("product", product);
        model.addAttribute("reviews", productReviews);
        model.addAttribute("newReview", new Review());
        return "productDetail";
    }

    @PostMapping("/add-review")
    public String addReview(@ModelAttribute("newReview") Review review) {
        review.setId(reviews.size() + 1); // Generate new ID
        reviews.add(review);
        return "redirect:/product-detail/" + review.getIdProduct();
    }


    @PostMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable int id, @RequestParam int quantity, @RequestParam int idUser) {
        Cart cart = new Cart();
        cart.setIdProduct(id);
        cart.setQuantity(quantity);
        cart.setIdUser(idUser);
        cartService.addToCart(cart);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(@RequestParam int idUser, Model model) {
        List<Cart> cartItems = cartService.getCartByUserId(idUser);
        List<Product> products = productService.findAll();

        double totalPrice = cartItems.stream()
                .mapToDouble(cart -> {
                    Product product = products.stream()
                            .filter(p -> p.getId() == cart.getIdProduct())
                            .findFirst()
                            .orElse(null);
                    return product != null ? product.getPrice() * cart.getQuantity() : 0;
                })
                .sum();

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("products", products);
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }
}
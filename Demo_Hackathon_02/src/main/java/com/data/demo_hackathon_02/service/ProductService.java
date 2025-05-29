package com.data.demo_hackathon_02.service;



import com.data.demo_hackathon_02.dto.ProductDTO;
import com.data.demo_hackathon_02.model.Product;
import com.data.demo_hackathon_02.repository.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private final ProductRepository productRepository = new ProductRepository();

    public List<Product> getAllProducts() throws SQLException {
        return productRepository.findAll();
    }

    public void addProduct(ProductDTO productDTO) throws SQLException {
        // Validate and call repository to save
    }

    public void updateProduct(int id, ProductDTO productDTO) throws SQLException {
        validateProduct(productDTO);
        productRepository.update(id, productDTO);
    }

    public void deleteProduct(int id) throws SQLException {
        productRepository.delete(id);
    }

    public List<Product> searchProducts(String keyword) throws SQLException {
        return productRepository.search(keyword);
    }

    private void validateProduct(ProductDTO productDTO) {
        if (productDTO.getProductName() == null || productDTO.getProductName().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        if (productDTO.getStatus() == null || (!productDTO.getStatus().equals("AVAILABLE") && !productDTO.getStatus().equals("NOT_AVAILABLE"))) {
            throw new IllegalArgumentException("Invalid status value.");
        }
    }
}
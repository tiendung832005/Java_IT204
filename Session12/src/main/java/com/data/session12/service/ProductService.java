package com.data.session12.service;


import com.data.session12.model.Product;
import com.data.session12.repository.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private final ProductRepository productRepository = new ProductRepository();

    public void save(Product product) throws SQLException {
        productRepository.save(product);
    }

    public void update(Product product) throws SQLException {
        productRepository.update(product);
    }

    public void deleteById(int id) throws SQLException {
        productRepository.deleteById(id);
    }

    public List<Product> findAll() throws SQLException {
        return productRepository.findAll();
    }

    public Product findById(int id) throws SQLException {
        return productRepository.findById(id);
    }
}

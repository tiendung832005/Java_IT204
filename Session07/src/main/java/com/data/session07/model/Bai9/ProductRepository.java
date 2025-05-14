package com.data.session07.model.Bai9;

import com.data.session07.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void update(Product product);
    void delete(Long id);
}

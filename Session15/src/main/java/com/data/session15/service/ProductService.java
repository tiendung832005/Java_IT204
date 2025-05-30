package com.data.session15.service;

import com.data.session15.model.Product;

import java.util.List;

public interface ProductService {
    List<com.data.session15.model.Product> findAll();
    int delete(int id);
    int save(Product product);
}

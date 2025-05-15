package com.data.session08.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    public List<String> getAllProducts() {
        return Arrays.asList("Product 1", "Product 2", "Product 3");
    }
}

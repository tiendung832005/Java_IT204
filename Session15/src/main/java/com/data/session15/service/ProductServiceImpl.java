package com.data.session15.service;

import com.data.session15.model.Product;
import com.data.session15.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepo;

    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public int delete(int id) {
        return productRepo.delete(id);
    }

    @Override
    public int save(Product product) {
        return productRepo.save(product);
    }
}

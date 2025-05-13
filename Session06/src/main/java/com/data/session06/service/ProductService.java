package com.data.session06.service;

import com.data.session06.dao.ProductDao;
import com.data.session06.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private final ProductDao productDao = new ProductDao();

    public List<Product> getAllProducts() throws SQLException {
        return productDao.getAllProducts();
    }
}

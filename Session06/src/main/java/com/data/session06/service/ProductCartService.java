package com.data.session06.service;


import com.data.session06.dao.ProductCartDao;

import java.sql.SQLException;

public class ProductCartService {
    private final ProductCartDao productCartDao = new ProductCartDao();

    public void addToCart(int userId, int productId, int quantity) throws SQLException {
        productCartDao.addToCart(userId, productId, quantity);
    }

    public void removeFromCart(int cartId) throws SQLException {
        productCartDao.removeFromCart(cartId);
    }
}

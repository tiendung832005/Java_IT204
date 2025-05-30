package com.data.session15.service;



import com.data.session15.model.Cart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private final List<Cart> cartDatabase = new ArrayList<>();

    public void addToCart(Cart cart) {
        cartDatabase.add(cart);
    }

    public List<Cart> getCartByUserId(int idUser) {
        return cartDatabase.stream()
                .filter(cart -> cart.getIdUser() == idUser)
                .toList();
    }
}

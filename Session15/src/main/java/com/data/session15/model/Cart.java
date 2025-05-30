package com.data.session15.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private int idCart;
    private int idUser;
    private int idProduct;
    private int quantity;
}
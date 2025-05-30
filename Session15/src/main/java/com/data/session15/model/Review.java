package com.data.session15.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private int id;
    private int idProduct;
    private int idUser;
    private int rating; // 1-5 stars
    private String comment;
}
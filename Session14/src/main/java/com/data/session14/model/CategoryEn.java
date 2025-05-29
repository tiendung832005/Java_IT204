package com.data.session14.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEn {
    private int id;
    private String categoryName;
    private String description;
}

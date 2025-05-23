package com.data.session11.entity;


import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
public class Category {


    private Integer id;

    @NotBlank(message = "Tên danh mục không được để trống!")
    @Size(max = 50, message = "Tên danh mục không được vượt quá 50 ký tự!")
    private String categoryName;


    private Boolean status = true;
}

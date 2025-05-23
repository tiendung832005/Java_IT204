package com.data.session11.dto;


import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ProductReviewDTO {

    @NotNull(message = "Tên không được để trống!")
    private String name;

    @NotNull(message = "Email không được để trống!")
    @Email(message = "Email không đúng định dạng!")
    private String email;

    @NotNull(message = "Đánh giá không được để trống!")
    @Min(value = 1, message = "Đánh giá phải từ 1 đến 5 sao!")
    @Max(value = 5, message = "Đánh giá phải từ 1 đến 5 sao!")
    private Integer rating;

    @Size(max = 200, message = "Bình luận không được vượt quá 200 ký tự!")
    private String comment;
}

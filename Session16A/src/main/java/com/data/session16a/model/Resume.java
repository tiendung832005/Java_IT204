package com.data.session16a.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
    private Long id;
    @NotBlank(message = "Tên k dc để trống")
    private String fullName;
    @NotBlank(message = "Email kh được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;
    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "\\d{10}", message = "Số điện thoại không hợp lệ, phải có 10 chữ số")
    private String phoneNumber;
    @NotBlank(message = "Học vấn không được để trống")
    private String education;
    @NotBlank(message = "Kinh nghiệm không được để trống")
    private String experience;
    @NotBlank(message = "Kỹ năng không được để trống")
    private String skills;
}

package com.data.session11.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserDTO {

    @NotBlank(message = "Name không được để trống!")
    @Size(min = 2, max = 30, message = "Name phải có độ dài từ 2 đến 30 ký tự!")
    private String name;

    @NotBlank(message = "Email không được để trống!")
    @Email(message = "Email không đúng định dạng!")
    private String email;

    @NotBlank(message = "Phone không được để trống!")
    @Size(min = 10, max = 15, message = "Phone phải có độ dài từ 10 đến 15 ký tự!")
    private String phone;

    @NotBlank(message = "Password không được để trống!")
    @Size(min = 6, max = 20, message = "Password phải có độ dài từ 6 đến 20 ký tự!")
    private String password;

    private boolean status;
}

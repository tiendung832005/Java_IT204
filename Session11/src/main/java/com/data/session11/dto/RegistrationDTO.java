package com.data.session11.dto;

import com.data.session11.validator.ValidEmail;
import com.data.session11.validator.ValidPassword;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegistrationDTO {

    @NotBlank(message = "Tên không được để trống!")
    @Size(min = 2, max = 30, message = "Tên phải có độ dài từ 2 đến 30 ký tự!")
    private String name;

    @NotBlank(message = "Email không được để trống!")
    @ValidEmail
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống!")
    @ValidPassword
    private String password;
}

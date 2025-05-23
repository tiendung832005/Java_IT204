package com.data.session11.dto;

import com.data.session11.validator.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegisterDTO {

    @NotBlank(message = "Tên không được để trống!")
    @Size(min = 2, max = 30, message = "Tên phải có độ dài từ 2 đến 30 ký tự!")
    private String name;

    @NotBlank(message = "Email không được để trống!")
    private String email;

    @NotBlank(groups = ValidationGroups.Admin.class, message = "Thông tin bổ sung cho Admin không được để trống!")
    private String adminInfo;

    @NotBlank(message = "Vai trò không được để trống!")
    private String role;
}

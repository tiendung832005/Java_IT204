package com.data.session16a.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Email
    private String email;

    private String role;

    private String status;
}
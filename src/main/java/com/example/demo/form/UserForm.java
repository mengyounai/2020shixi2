package com.example.demo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserForm {

    @NotEmpty(message = "邮箱必填")
    private String userEmail;

    @NotEmpty(message = "密码必填")
    private String userPassword;
}

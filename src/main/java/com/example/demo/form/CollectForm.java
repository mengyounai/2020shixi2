package com.example.demo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CollectForm {

    @NotEmpty(message = "用户ID必须有")
    private Integer userId;

    private Integer animeId;

    private Integer bookId;

    private Integer musicId;

    private Integer peopleId;

    @NotEmpty(message = "收藏信息不能为空")
    private String items;


}

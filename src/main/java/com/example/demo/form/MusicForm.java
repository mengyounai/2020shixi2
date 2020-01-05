package com.example.demo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MusicForm {

    private Integer musicId;

    @NotEmpty(message = "音乐名称必填")
    private String musicName;

    private String musicTime;

    private String musicAuthor;

    private Integer labelType;

    private String musicDescription;

    private String musicIcon;

}

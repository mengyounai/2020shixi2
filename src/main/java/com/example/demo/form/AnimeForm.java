package com.example.demo.form;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Data
public class AnimeForm {

    private Integer animeId;

    @NotEmpty(message = "动漫名称必填")
    private String animeName;

    private String animeTime;

    private String animeAuthor;

    private String animeDescription;

    private String animeIcon;

    private String animeCharacter;

    private String animeJishu;




}

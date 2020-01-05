package com.example.demo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PeopleForm {

    private Integer peopleId;

    @NotEmpty(message = "人物名称必填")
    private String peopleName;

    private String peopleBirthday;

    private String peopleSex;

    private Integer labelType;

    private String animeDescription;

    private String peopleIcon;

    private String animeId;

}

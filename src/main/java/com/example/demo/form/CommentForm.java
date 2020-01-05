package com.example.demo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CommentForm {

    private Integer commentId;

    private Integer userId;

    private Integer animeId;

    private Integer bookId;

    private Integer musicId;

    private Integer peopleId;

    private String commentDescription;


}

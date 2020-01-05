package com.example.demo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BookForm {

    private Integer bookId;

    @NotEmpty(message = "书籍名称必填")
    private String bookName;

    private String bookTime;

    private String bookAuthor;

    private Integer labelType;

    private String bookDescription;

    private String bookIcon;



}

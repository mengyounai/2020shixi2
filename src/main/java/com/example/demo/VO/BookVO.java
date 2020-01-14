package com.example.demo.VO;

import com.example.demo.enums.ProductStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class BookVO {

    @Id
    private Integer bookId;

    @JsonProperty("name")
    private String bookName;

    @JsonProperty("icon")
    private String bookIcon;

    @JsonProperty("time")
    private String bookTime;

    @JsonProperty("author")
    private String bookAuthor;

    private Integer labelType;

    private String bookDescription;

    private Double score;

    private Integer number=0;

    private boolean show=true;

    private boolean show2=false;

    private boolean show3=true;

    private Integer collectStatus=0;

    private Integer bookStatus= ProductStatusEnum.UP.getCode();

    private String bookIsbn;

    @JsonProperty("jishu")
    private String bookJishu;

    private Date createTime;

    private Date updateTime;
}

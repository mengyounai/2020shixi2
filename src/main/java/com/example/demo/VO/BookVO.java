package com.example.demo.VO;

import com.example.demo.enums.ProductStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class BookVO {

    @Id
    private Integer bookId;

    private String bookName;

    private String bookIcon;

    private String bookTime;

    private String bookAuthor;

    private Integer labelType;

    private String bookDescription;

    private Double score;

    private Integer number=0;

    private boolean show=true;

    private boolean show2=false;

    private Integer collectStatus=0;

    private Integer bookStatus= ProductStatusEnum.UP.getCode();

    private String bookIsbn;

    private String bookJishu;

    private Date createTime;

    private Date updateTime;
}

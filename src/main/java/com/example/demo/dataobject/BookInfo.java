package com.example.demo.dataobject;

import com.example.demo.enums.ProductStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Proxy(lazy = false)
@Data
@DynamicInsert
@DynamicUpdate
public class BookInfo implements Serializable {

    @Id
    private Integer bookId;

    private String bookName;

    private String bookIcon;

    private String bookTime;

    private String bookAuthor;

    private Integer labelType;

    private String bookDescription;

    private Integer bookStatus= ProductStatusEnum.UP.getCode();

    private String bookIsbn;

    private String bookJishu;

    private Date createTime;

    private Date updateTime;

}

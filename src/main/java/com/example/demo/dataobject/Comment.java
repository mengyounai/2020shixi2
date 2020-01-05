package com.example.demo.dataobject;

import com.example.demo.enums.ProductStatusEnum;
import com.example.demo.util.Date2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Proxy(lazy = false)
@Data
@DynamicInsert
@DynamicUpdate
public class Comment {

    @Id
    private Integer commentId;

    private Integer userId;

    private String commentDescription;

    private Integer animeId;

    private Integer bookId;

    private Integer musicId;

    private Integer peopleId;

    private Integer commentStatus= ProductStatusEnum.UP.getCode();

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;


}

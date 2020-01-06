package com.example.demo.VO;

import com.example.demo.enums.ProductStatusEnum;
import com.example.demo.util.Date2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class CommentVO {

    @Id
    private String commentId;

    private Integer userId;

    private String commentDescription;

    private Integer animeId;

    private Integer bookId;

    private Integer musicId;

    private Integer peopleId;

    private String userName;

    private String userIcon;

    private Integer commentStatus= ProductStatusEnum.UP.getCode();

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
}

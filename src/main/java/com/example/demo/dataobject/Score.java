package com.example.demo.dataobject;

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
public class Score {

    @Id
    private String scoreId;

    private Integer userId;

    private Integer animeId;

    private Integer bookId;

    private Integer musicId;

    private double score;

    private Date createTime;

    private Date updateTime;
}

package com.example.demo.dataobject;

import com.example.demo.enums.CollectEnum;
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
public class Collection {

    @Id
    private String collectionId;

    private Integer userId;

    private Integer animeId;

    private Integer bookId;

    private Integer musicId;

    private Integer peopleId;

    private Integer collectionStatus= CollectEnum.New.getCode();

    private Date createTime;

    private Date updateTime;
}

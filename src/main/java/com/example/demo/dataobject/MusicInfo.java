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
public class MusicInfo implements Serializable {

    @Id
    private Integer musicId;

    private String musicName;

    private String musicIcon;

    private String musicTime;

    private String musicAuthor;

    private Integer labelType;

    private String musicDescription;

    private Integer musicPrice;

    private Integer musicStatus= ProductStatusEnum.UP.getCode();

    private Date createTime;

    private Date updateTime;
}

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
public class AnimeInfo implements Serializable {

    @Id
    public Integer animeId;

    private String animeName;

    private String animeIcon;

    private String animeTime;

    private String animeAuthor;

    private Integer labelType;

    private String animeDescription;

    private Integer animeStatus= ProductStatusEnum.UP.getCode();

    private String animeCharacter;

    private String animeJishu;

    private Date createTime;

    private Date updateTime;

}

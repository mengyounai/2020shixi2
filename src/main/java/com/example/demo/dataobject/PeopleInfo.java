package com.example.demo.dataobject;

import com.example.demo.enums.ProductStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PeopleInfo implements Serializable {

    @Id
    private Integer peopleId;

    private String peopleName;

    private String peopleIcon;

    private String peopleIcon2;

    private String peopleSex;

    private String peopleBirthday;

    private String peopleHeight;

    private Integer labelType;

    private Integer animeId;

    private Integer bookId;

    private String peopleDescription;

    private Integer peopleStatus= ProductStatusEnum.UP.getCode();

    private Date createTime;

    private Date updateTime;
}

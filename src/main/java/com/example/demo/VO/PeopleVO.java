package com.example.demo.VO;

import com.example.demo.enums.ProductStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class PeopleVO {

    private Integer peopleId;

    @JsonProperty("name")
    private String peopleName;

    private String peopleIcon;

    private String peopleIcon2;

    private String peopleSex;

    @JsonProperty("time")
    private String peopleBirthday;

    private String peopleHeight;

    private Integer labelType;

    private Integer animeId;

    private Integer bookId;

    private String peopleDescription;

    private Integer peopleStatus;

    private Integer collectStatus=0;

    private Date createTime;

    private Date updateTime;
}

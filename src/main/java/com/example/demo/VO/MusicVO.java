package com.example.demo.VO;

import com.example.demo.enums.ProductStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class MusicVO {

    @Id
    private Integer musicId;

    @JsonProperty("name")
    private String musicName;

    @JsonProperty("icon")
    private String musicIcon;

    @JsonProperty("time")
    private String musicTime;

    @JsonProperty("author")
    private String musicAuthor;

    private Integer labelType;

    private String musicDescription;

    private Integer musicPrice;

    private Double score;

    private Integer number=0;

    private boolean show=true;

    private boolean show2=false;

    private boolean show3=true;

    private Integer collectStatus=0;

    private Integer musicStatus= ProductStatusEnum.UP.getCode();

    private Date createTime;

    private Date updateTime;
}

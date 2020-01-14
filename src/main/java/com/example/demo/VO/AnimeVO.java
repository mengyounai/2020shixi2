package com.example.demo.VO;

import com.example.demo.enums.ProductStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AnimeVO {

    public Integer animeId;

    @JsonProperty("name")
    private String animeName;

    @JsonProperty("icon")
    private String animeIcon;

    @JsonProperty("time")
    private String animeTime;

    @JsonProperty("author")
    private String animeAuthor;

    private Integer labelType;

    private String animeDescription;

    private Double score;

    private Integer number=0;

    private boolean show=true;

    private boolean show2=false;

    private boolean show3=true;

    private Integer collectStatus=0;

    private Integer animeStatus= ProductStatusEnum.UP.getCode();

    private String animeCharacter;

    @JsonProperty("jishu")
    private String animeJishu;

    private Date createTime;

    private Date updateTime;


}

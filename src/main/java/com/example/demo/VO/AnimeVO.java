package com.example.demo.VO;

import com.example.demo.enums.ProductStatusEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AnimeVO {

    public Integer animeId;

    private String animeName;

    private String animeIcon;

    private String animeTime;

    private String animeAuthor;

    private Integer labelType;

    private String animeDescription;

    private Double score;

    private Integer number=0;

    private boolean show=true;

    private boolean show2=false;

    private Integer collectStatus=0;

    private Integer animeStatus= ProductStatusEnum.UP.getCode();

    private String animeCharacter;

    private String animeJishu;

    private Date createTime;

    private Date updateTime;


}

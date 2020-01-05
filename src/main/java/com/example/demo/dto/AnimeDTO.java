package com.example.demo.dto;

import com.example.demo.dataobject.Comment;
import com.example.demo.enums.CollectEnum;
import com.example.demo.enums.ProductStatusEnum;
import com.example.demo.util.Date2LongSerializer;
import com.example.demo.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimeDTO {

    private Integer animeId;

    private String animeName;

    private String animeIcon;

    private String animeTime;

    private String animeAuthor;

    private Integer labelType;

    private String animeDescription;

    private Integer animeStatus= ProductStatusEnum.UP.getCode();

    private String animeCharacter;

    private String animeJishu;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private Comment comment;

    public ProductStatusEnum getAnimeStatusEnum(){
        return EnumUtil.getEnumbyCode(animeStatus,ProductStatusEnum.class);
    }

}

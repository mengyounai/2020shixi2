package com.example.demo.dto;

import com.example.demo.dataobject.*;
import com.example.demo.enums.CollectEnum;
import com.example.demo.util.Date2LongSerializer;
import com.example.demo.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollectionDTO {

    private String collectionId;

    private Integer userId;

    private Integer animeId;

    private Integer bookId;

    private Integer musicId;

    private Integer peopleId;

    private Integer collectionStatus= CollectEnum.New.getCode();

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<Detail> detailList ;

    public CollectEnum getCollectionStatusEnum(){
        return EnumUtil.getEnumbyCode(collectionStatus,CollectEnum.class);
    }





}

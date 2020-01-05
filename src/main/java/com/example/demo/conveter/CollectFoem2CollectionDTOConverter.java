package com.example.demo.conveter;

import com.example.demo.dataobject.Detail;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.form.CollectForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class CollectFoem2CollectionDTOConverter {

    public static CollectionDTO convert(CollectForm collectForm){

        CollectionDTO collectionDTO=new CollectionDTO();
        collectionDTO.setUserId(collectForm.getUserId());
        collectionDTO.setAnimeId(collectForm.getAnimeId());
        collectionDTO.setBookId(collectForm.getBookId());
        collectionDTO.setMusicId(collectForm.getMusicId());
        collectionDTO.setPeopleId(collectForm.getPeopleId());

        List<Detail> detailList=new ArrayList<>();
        try {
            Gson gson=new Gson();
            detailList=gson.fromJson(collectForm.getItems(),new TypeToken<List<Detail>>(){}.getType());
        }catch (Exception e){
            log.error("[对象转换]错误，string={}",collectForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        collectionDTO.setDetailList(detailList);

        return collectionDTO;


    }
}

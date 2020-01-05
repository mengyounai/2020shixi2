package com.example.demo.conveter;

import com.example.demo.dataobject.Collection;
import com.example.demo.dto.CollectionDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Slf4j
public class Collection2CollectionDTOConveter {

    //转换单个对象
    public static CollectionDTO convert(Collection collection){

        CollectionDTO collectionDTO=new CollectionDTO();
        BeanUtils.copyProperties(collection,collectionDTO);

        return collectionDTO;
    }


    //转换多个对象
    public static List<CollectionDTO> convert(List<Collection> collectionList){
        return collectionList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }


}

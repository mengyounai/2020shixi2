package com.example.demo.controller;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.Detail;
import com.example.demo.dataobject.Label;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.service.AnimeService;
import com.example.demo.service.CollectionService;
import com.example.demo.service.LabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/label")
@Slf4j
public class UserLabelController {

    @Autowired
    private AnimeService animeService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private CollectionService collectionService;

    //查询标签列表
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size,
                             @RequestParam(value = "label",defaultValue = "1") Integer label,
                              Map<String,Object> map){

        List<AnimeInfo> animeInfoList2=animeService.findUpAll();

        Page<AnimeInfo> animeInfoPage2=new PageImpl<>(animeInfoList2);

        List<AnimeInfo> animeInfoList=animeService.findOne2(label);

        Page<AnimeInfo> animeInfoPage=new PageImpl<>(animeInfoList);

        List<AnimeInfo> animeInfoList3=collectionService.findByuserId(1,PageRequest.of(page-1,size));

        List<Label> labelList=labelService.labelList();

        Page<CollectionDTO> collectionDTOPage = collectionService.findAnimeAll(1, PageRequest.of(page-1, size));

        map.put("animeInfoList3",animeInfoList3);
        map.put("animeInfoPage2",animeInfoPage2);
        map.put("animeInfoPage",animeInfoPage);
        map.put("collectionDTOPage",collectionDTOPage);
        map.put("labelList",labelList);
        map.put("animeInfoList",animeInfoList);
        map.put("currentPage",page);
        map.put("size",size);
        map.put("label",label);

        return new ModelAndView("label/list",map);

    }
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam(value = "collectionId" ) String collectionId,
                               Map<String,Object> map){

        try {
            CollectionDTO collectionDTO=collectionService.f(collectionId);
            collectionService.cancel(collectionDTO);
        }
        catch (SellException e){
            log.error("[用户取消收藏] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/user/label/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.COLLECTION_CANCEL_SUCCESS.getMessage());
        map.put("url","/bangumi/user/label/list");

        return new ModelAndView("common/success",map);

    }
    @GetMapping("/create")
    public ModelAndView create(@RequestParam(value = "animeId") Integer animeId,
                               @RequestParam(value = "userId",defaultValue = "1") Integer userId,
//                               @RequestParam(value = "collectionId" ) String collectionId,
                               Map<String,Object> map){

        CollectionDTO collectionDTO=new CollectionDTO();
        collectionDTO.setAnimeId(animeId);
        collectionDTO.setUserId(userId);
//        collectionDTO.setCollectionId(collectionId);

        List<Detail> detailList=new ArrayList<>();
        Detail o1=new Detail();
        o1.setAnimeId(animeId);
        detailList.add(o1);
        collectionDTO.setDetailList(detailList);

        try {
            CollectionDTO result=collectionService.create(collectionDTO);
        }
        catch (SellException e){
            log.error("[用户收藏] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/user/label/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.COLLECTION_UPDATE_SUCCESS.getMessage());
        map.put("url","/bangumi/user/label/list");

        return new ModelAndView("common/success",map);

    }
}



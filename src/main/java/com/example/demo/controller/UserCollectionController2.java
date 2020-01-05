package com.example.demo.controller;

import com.example.demo.dataobject.Collection;
import com.example.demo.dataobject.Detail;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.service.CollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/anime")
@Slf4j
public class UserCollectionController2 {

    @Autowired
    private CollectionService collectionService;

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
            map.put("url","/bangumi/user/anime/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.COLLECTION_CANCEL_SUCCESS);
        map.put("url","/bangumi/user/anime/list");

        return new ModelAndView("common/success",map);

    }
    @GetMapping("/cancel2")
    public ModelAndView cancel2(@RequestParam(value = "collectionId" ) String collectionId,
                               Map<String,Object> map){

        try {
            CollectionDTO collectionDTO=collectionService.f(collectionId);
            collectionService.cancel(collectionDTO);
        }
        catch (SellException e){
            log.error("[用户取消收藏] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/user/book/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.COLLECTION_CANCEL_SUCCESS);
        map.put("url","/bangumi/user/book/list");

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
            map.put("url","/bangumi/user/anime/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.COLLECTION_UPDATE_SUCCESS);
        map.put("url","/bangumi/user/anime/list");

        return new ModelAndView("common/success",map);

    }

    @GetMapping("/create2")
    public ModelAndView create2(@RequestParam(value = "bookId") Integer bookId,
                               @RequestParam(value = "userId",defaultValue = "1") Integer userId,
//                               @RequestParam(value = "collectionId" ) String collectionId,
                               Map<String,Object> map){

        CollectionDTO collectionDTO=new CollectionDTO();
        collectionDTO.setBookId(bookId);
        collectionDTO.setUserId(userId);
//        collectionDTO.setCollectionId(collectionId);

        List<Detail> detailList=new ArrayList<>();
        Detail o1=new Detail();
        o1.setBookId(bookId);
        detailList.add(o1);
        collectionDTO.setDetailList(detailList);

        try {
            CollectionDTO result=collectionService.create2(collectionDTO);
        }
        catch (SellException e){
            log.error("[用户收藏] 发生异常,result={}",e);

            map.put("msg",e.getMessage());
            map.put("url","/bangumi/user/book/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.COLLECTION_UPDATE_SUCCESS);
        map.put("url","/bangumi/user/book/list");

        return new ModelAndView("common/success",map);

    }
}

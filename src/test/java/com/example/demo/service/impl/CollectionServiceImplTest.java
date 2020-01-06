package com.example.demo.service.impl;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.dataobject.Collection;
import com.example.demo.dataobject.Detail;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.enums.CollectEnum;
import com.example.demo.service.AnimeService;
import com.example.demo.service.CollectionService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CollectionId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CollectionServiceImplTest {

    @Autowired
    private CollectionService collectionService;

    @Test
    public void create() {

        CollectionDTO collectionDTO=new CollectionDTO();
        collectionDTO.setAnimeId(11);
        collectionDTO.setUserId(2);

        //收藏夹
        List<Detail> detailList=new ArrayList<>();
        Detail o1=new Detail();
        o1.setAnimeId(11);
        Detail o2=new Detail();
        o2.setAnimeId(12);
        detailList.add(o1);
        detailList.add(o2);

        collectionDTO.setDetailList(detailList);

        CollectionDTO result=collectionService.create(collectionDTO);

        log.info("[创建收藏] result="+result);
        assertNotNull(result);



    }

    @Test
    public void findAll() {
        Page<CollectionDTO> collectionDTOPage=collectionService.findAll(1, PageRequest.of(0,10));
        log.info("[查询用户收藏总数] result="+collectionDTOPage.getTotalElements());
        assertNotEquals(0,collectionDTOPage.getTotalElements());

    }

    @Test
    public void f() {
        CollectionDTO collectionDTO=collectionService.f("1560441672093389800");
        log.info("[查询收藏] result="+collectionDTO);
        assertEquals("1560441672093389800",collectionDTO.getCollectionId());
    }

    @Test
    public void cancel() {

        CollectionDTO collectionDTO=collectionService.f("1560441672093389800");
        CollectionDTO result=collectionService.cancel(collectionDTO);

        assertEquals(CollectEnum.New.getCode(),result.getCollectionStatus());

    }

    @Test
    public void findAnime(){

        List<AnimeInfo> animeInfoListList=collectionService.findByuserId(1,PageRequest.of(0,10));
        log.info("[查询动漫总数] result="+animeInfoListList.size());
        assertNotEquals(0,animeInfoListList.size());
    }

    @Test
    public void findAnimeAll(){
        Page<CollectionDTO> collectionDTOPage=collectionService.findAnimeAll(1, PageRequest.of(0,2));
        log.info("[查询用户收藏动漫总数] result="+collectionDTOPage.getTotalElements());
        assertNotEquals(0,collectionDTOPage.getTotalElements());
    }

    @Test
    public void findList(){
        Page<CollectionDTO> list = collectionService.findList(PageRequest.of(0, 5));
        log.info("[查询用户收藏动漫总数] result="+list.getTotalElements());
        assertNotEquals(0,list.getTotalElements());
    }

    @Test
    public void animecreate(){
        collectionService.animecreate(1,2,11);
    }

    @Test
    public void bookcreate(){
        collectionService.bookcreate(1,2,3);
    }


}
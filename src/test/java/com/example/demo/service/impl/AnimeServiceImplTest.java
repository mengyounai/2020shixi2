package com.example.demo.service.impl;

import com.example.demo.dataobject.AnimeInfo;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.service.ScoreService;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AnimeServiceImplTest {

    @Autowired
    private AnimeServiceImpl animeService;

    @Autowired
    private ScoreService scoreService;

    @Test
    public void findOne() {
        AnimeInfo animeInfo=animeService.findOne(11);

        if (animeInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        assertNotEquals("11",animeInfo.getAnimeId());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<AnimeInfo> animeInfoPage=animeService.findAll(pageRequest);
        assertNotEquals(0,animeInfoPage.getTotalElements());
    }

    @Test
    public void findUpAll() {
        List<AnimeInfo> animeInfoList=animeService.findUpAll();
        assertNotEquals(0,animeInfoList.size());
    }

    @Test
    public void findUpAll2(){
        Page<AnimeInfo> animeInfoPag=animeService.findUpAll(PageRequest.of(1,1));
        log.info("[Page总数] number={}",animeInfoPag.getTotalElements());
        assertNotEquals(0,animeInfoPag.getTotalElements());
    }

    @Test
    public void save() {
        AnimeInfo animeInfo=new AnimeInfo();
        animeInfo.setAnimeId(11);
        animeInfo.setAnimeName("末日时在干什么");
        animeInfo.setAnimeIcon("morisanwen");
        animeInfo.setAnimeTime("2002-02-07");
        animeInfo.setAnimeAuthor("枯野瑛");
        animeInfo.setLabelType(1);
        animeInfo.setAnimeDescription("“末日时在做什么？有没有空？可以来拯救吗？”\n" +
                "就如标题所言，这是一部末日系小说，本作时间设定在人类世界毁灭之后的“末日”，而故事的舞台则是一个上有神明，下有人、龙、兽等不同种族的标准幻想世界。作品以人类灭亡后五百年的世界为舞台，妖精少女们与人类青年共同经历的日子。\n" +
                "人类灭亡了——500年前，被人类制造出的“17兽”的怪物失控反而被兽消灭，其它种族后来逃离大地，生活在浮空岛上。\n" +
                "在世界毁灭前，人类的建立的勇者体系和量产化的圣剑令人类站在这个异世界的巅峰，他们四处讨伐，灭除那些会对人类造成危害的其他种族。但就是这样强大的人类几乎却在地面上出现正体不明且力量强大的“兽”之后仅仅几天就惨遭灭亡。\n" +
                "而其他的种族也未能幸免，“兽”群占据了大地，原先的世界自此毁灭。残存的种族在“大贤者”的帮助下逃到了由众多悬浮岛屿组成的空中大陆上，并在那里建立起了新的家园。在500年后，冒着生命危险降落到地面上发掘资源的探险队意外发现了因为石化而从“兽”手中死里逃生的男主角，并将他带回了悬浮大陆。");
        animeInfo.setAnimeStatus(0);
        animeInfo.setAnimeCharacter("珂朵莉");



        AnimeInfo result=animeService.save(animeInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void Up(){
        AnimeInfo up = animeService.Up(11);

    }
    
    @Test
    public void down(){
        animeService.down(1);
    }

    @Test
    public void findone2(){
        List<AnimeInfo> animeInfoList=animeService.findOne2(1);

        for (AnimeInfo animeInfo:animeInfoList){
            log.info("[id] animeId={}",animeInfo.animeId);
        }
        assertNotEquals(0,animeInfoList);
    }

    @Test
    public void labelAll(){
        List<String> integers = animeService.labelAll();
        log.info("[类型数量：],number={}",integers.size());
    }

    @Test
    public void animeList(){
        List<AnimeInfo> animeInfoList = animeService.findOne3("热血");
        log.info("[类型数量：],number={}",animeInfoList);
    }

    @Test
    public void timeAll(){
        List<Integer> timeAll=animeService.timeAll();

        Collections.sort(timeAll);

        for (Integer time:timeAll){
            System.out.println(time);
        }
    }


}
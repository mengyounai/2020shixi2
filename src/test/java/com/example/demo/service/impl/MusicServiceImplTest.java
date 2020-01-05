package com.example.demo.service.impl;

import com.example.demo.dataobject.MusicInfo;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MusicServiceImplTest {

    @Autowired
    private MusicServiceImpl musicService;

    @Test
    public void findOne() {
        MusicInfo musicInfo=musicService.findOne(1);

        if (musicInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        assertNotEquals("11",musicInfo.getMusicId());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<MusicInfo> musicInfoPage=musicService.findAll(pageRequest);
        assertNotEquals(0,musicInfoPage.getTotalElements());
    }

    @Test
    public void findUpAll() {
        List<MusicInfo> musicInfoList=musicService.findUpAll();
        assertNotEquals(0,musicInfoList.size());
    }

    @Test
    public void save() {
        MusicInfo musicInfo=new MusicInfo();
        musicInfo.setMusicId(11);
        musicInfo.setMusicName("escape");
        musicInfo.setMusicIcon("1");
        musicInfo.setMusicTime("2002-02-07");
        musicInfo.setMusicAuthor("fripSide");
        musicInfo.setLabelType(1);
        musicInfo.setMusicDescription("炒冷饭系列");
        musicInfo.setMusicStatus(1);


        MusicInfo result=musicService.save(musicInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void Up(){
        MusicInfo up = musicService.Up(11);

    }

    @Test
    public void down(){
        musicService.down(1);
    }

}
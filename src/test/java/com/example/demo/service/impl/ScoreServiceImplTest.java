package com.example.demo.service.impl;

import com.example.demo.VO.RateVO;
import com.example.demo.dataobject.Score;
import com.example.demo.reposipory.ScoreRepository;
import com.example.demo.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
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
public class ScoreServiceImplTest {

    @Autowired
    private ScoreRepository repository;

    @Autowired
    private ScoreService scoreService;

    @Test
    public void findByAnimeId() {
    }

    @Test
    public void findByBookId() {
    }

    @Test
    public void findByMusicId() {
    }

    @Test
    public  void scoreresult(){
        PageRequest pageRequest=new PageRequest(1,100);
        scoreService.score(11);
        log.info("[评分平均分] result="+scoreService.score(11));
    }

    @Test
    public  void scoresum(){
        scoreService.scoresum();
        log.info("[评分平均分] result="+scoreService.scoresum());
    }

    @Test
    public void findAnimeAll() {
        PageRequest pageRequest=new PageRequest(0,10);
        List<Score> scorePage=repository.findByAnimeId(11);


        log.info("[查询动漫评分总数] result="+scorePage);
    }

    @Test
    public void scoreup() {

        Score score=scoreService.animescore(2,1,2);

        log.info("[查询评分详情] result=",score);
    }

    @Test
    public void scorelist() {

        RateVO rateVO =scoreService.scorelist(10);

        System.out.println(rateVO);

        log.info("[查询每个评分数量] result=",rateVO);
    }

    @Test
    public void findBookAll() {
    }

    @Test
    public void findMusicAll() {
    }
}
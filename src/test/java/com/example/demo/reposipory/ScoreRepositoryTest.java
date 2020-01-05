package com.example.demo.reposipory;

import com.example.demo.dataobject.Score;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ScoreRepositoryTest {

    @Autowired
    ScoreRepository repository;

    @Test
    public void findByAnimeId() {
        PageRequest pageRequest=new PageRequest(1,2);
        Page<Score> scorePage=repository.findByAnimeId(11,pageRequest);
        log.info("[查询动漫评分总数] result="+scorePage.getTotalElements());
    }

    @Test
    public void findByBookId() {
    }

    @Test
    public void findByMusicId() {
    }
}
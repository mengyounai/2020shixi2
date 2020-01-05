package com.example.demo.service.impl;

import com.example.demo.dataobject.PeopleInfo;
import com.example.demo.service.PeopleService;
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
public class PeopleServiceImplTest {

    @Autowired
    private PeopleService peopleService;

    @Test
    public void findOne() {
        PeopleInfo peopleInfo=peopleService.findOne(1);
        log.info("[用户姓名为] name={}",peopleInfo.getPeopleName());
        assertNotNull(peopleInfo);
    }

    @Test
    public void findAll() {
        Page<PeopleInfo> peopleInfoPage=peopleService.findAll(PageRequest.of(0,2));
        log.info("[用户数量为] number={}",peopleInfoPage.getTotalElements());
        assertNotNull(peopleInfoPage);
    }
}
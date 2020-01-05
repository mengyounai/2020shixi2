package com.example.demo.service.impl;

import com.example.demo.dataobject.UserInfo;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void findCollectOne() {
    }

    @Test
    public void cancelCollection() {
    }

    @Test
    public void findOne(){

        UserInfo userInfo=userService.findone("3223137@qq.com","222");
        log.info("[用户名为] name={}",userInfo.getUserName());
        assertNotNull(userInfo);
    }

}
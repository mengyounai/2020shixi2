package com.example.demo.service.impl;

import com.example.demo.VO.UserVO;
import com.example.demo.dataobject.UserInfo;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.reposipory.UserInfoRespository;
import com.example.demo.service.CollectionService;
import com.example.demo.service.UserService;
import com.example.demo.util.KeyUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private UserInfoRespository respository;

    @Autowired
    private UserService userService;


    private CollectionDTO checkCollectOwner(Integer userId,String collectId){
        CollectionDTO collectionDTO=collectionService.f(collectId);
        if (collectionDTO == null) {
            return null;
        }
        //判断是否自己的收藏
        if (!collectionDTO.getUserId().equals(userId)){
            log.error("[查询收藏]收藏的userId不一致,openId={},collectionDTO={}",userId,collectionDTO);
        }
        return collectionDTO;
    }

    @Override
    public CollectionDTO findCollectOne(Integer userId, String collectionId) {
        return checkCollectOwner(userId,collectionId);
    }

    @Override
    public CollectionDTO cancelCollection(Integer userId, String collectionId) {

        CollectionDTO collectionDTO=checkCollectOwner(userId,collectionId);
        if (collectionDTO == null) {
            log.error("[取消收藏]查不到该收藏,collectId={}",collectionId);
            throw new SellException(ResultEnum.COLLECTION_OWNER_ERROR);
        }
        return collectionService.cancel(collectionDTO);
    }

    @Override
    public UserInfo findone(String userEmail, String userpassword) {
       UserInfo userInfo = respository.findByUserEmailAndUserPassword(userEmail,userpassword);
        return userInfo;
    }

    @Override
    public UserInfo findbyuserId(Integer userId) {
        return respository.findByUserId(userId);
    }

    @Override
    public UserInfo save(Integer userId,String name, Integer sex, String birth, String qianming, String des) {

        UserInfo userInfo=new UserInfo();

        UserInfo userInfo1=respository.findByUserId(userId);

        userInfo=userInfo1;

        userInfo.setUserName(name);
        userInfo.setUserSex(sex);
        userInfo.setUserBirth(birth);
        userInfo.setUserQianming(qianming);
        userInfo.setUserDes(des);

        respository.save(userInfo);

        return userInfo;
    }

    @Override
    public UserVO findone(Integer userId) {

        UserInfo userInfo=respository.findByUserId(userId);

        UserVO userVO=new UserVO();

        BeanUtils.copyProperties(userInfo,userVO);

        return userVO;
    }

    @Override
    public Boolean password(Integer userId, String email, String password1, String password2) {

        UserInfo userInfo=new UserInfo();

        Boolean a=true;

        userInfo=respository.findByUserId(userId);
        if (userInfo.getUserPassword().equalsIgnoreCase(password1)&&userInfo.getUserEmail().equalsIgnoreCase(email)){
            userInfo.setUserPassword(password2);
            respository.save(userInfo);
            a=true;
        }else {
            a=false;
        }
        return a;

    }

    @Override
    public Boolean register(String username, String email, String password) {

        UserInfo userInfo=new UserInfo();
        userInfo.setUserEmail(email);
        userInfo.setUserName(username);
        userInfo.setUserPassword(password);

        respository.save(userInfo);

        return true;
    }
}

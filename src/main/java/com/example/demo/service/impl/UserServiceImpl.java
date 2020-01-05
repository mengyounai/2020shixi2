package com.example.demo.service.impl;

import com.example.demo.dataobject.UserInfo;
import com.example.demo.dto.CollectionDTO;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.reposipory.UserInfoRespository;
import com.example.demo.service.CollectionService;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
}

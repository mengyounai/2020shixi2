package com.example.demo.service;

import com.example.demo.dataobject.UserInfo;
import com.example.demo.dto.CollectionDTO;

public interface UserService {

    //用户查询收藏
    CollectionDTO findCollectOne(Integer userId, String collectionId);

    //用户取消收藏
    CollectionDTO cancelCollection(Integer userId,String collectionId);

    //查询单个用户
    UserInfo findone(String userEmail, String userpassword);
}

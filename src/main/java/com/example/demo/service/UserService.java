package com.example.demo.service;

import com.example.demo.VO.UserVO;
import com.example.demo.dataobject.UserInfo;
import com.example.demo.dto.CollectionDTO;

import javax.validation.constraints.Email;

public interface UserService {

    //用户查询收藏
    CollectionDTO findCollectOne(Integer userId, String collectionId);

    //用户取消收藏
    CollectionDTO cancelCollection(Integer userId,String collectionId);

    //查询单个用户
    UserInfo findone(String userEmail, String userpassword);

    //根据用户Id查询用户
    UserInfo findbyuserId(Integer userId);

    //保存用户信息
    UserInfo save(Integer userId,String name,Integer sex,String birth,String qianming,String des);

    //查询单个用户
    UserVO findone(Integer userId);

    //修改密码
    Boolean password(Integer userId, String email,String password1,String password2);

    //注册用户
    Boolean register(String username,String email,String password);
}

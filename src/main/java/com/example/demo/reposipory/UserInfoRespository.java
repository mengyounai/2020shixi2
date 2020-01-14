package com.example.demo.reposipory;

import com.example.demo.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRespository extends JpaRepository<UserInfo,Integer> {

    public UserInfo findByUserEmailAndUserPassword(String userEmail,String userPassword);

    //根据用户id查询用户
    UserInfo findByUserId(Integer userId);

    //根据用户名查询用户
    UserInfo findByUserName(String username);


}

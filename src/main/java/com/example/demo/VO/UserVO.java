package com.example.demo.VO;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class UserVO {

    @Id
    private Integer userId;

    private String userName;

    private Integer userSex;

    private String userPhone;

    private String userIcon;

    private String userBirth;

    private String userQianming;

    private String userDes;

    private Date createTime;

    private Date updateTime;

}

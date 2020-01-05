package com.example.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Proxy(lazy = false)
@Data
@DynamicInsert
@DynamicUpdate
public class UserInfo {

    @Id
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String userPhone;

    private String userIcon;

    private Date createTime;

    private Date updateTime;




}

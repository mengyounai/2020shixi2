package com.example.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Proxy(lazy = false)
@Data
@DynamicInsert
@DynamicUpdate
public class Label {

    @Id
    private Integer labelId;

    private String labelName;

    private Integer labelType;

    private Date createTime;

    private Date updateTime;



}

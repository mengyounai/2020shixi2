package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum  CollectEnum implements CodeEnum {

    New(0,"收藏"),
    New2(1,"在看"),
    FINISH(2,"看过")
    ;

    private Integer code;

    private String msg;

    CollectEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CollectEnum getCollectionStatusEnum(Integer code){
        for (CollectEnum collectEnum:CollectEnum.values()){
            if (collectEnum.getCode().equals(code)){
                return collectEnum;
            }
        }
        return null;
    }
}
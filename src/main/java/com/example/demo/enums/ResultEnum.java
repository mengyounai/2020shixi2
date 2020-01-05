package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum  ResultEnum {

    SUCCESS(0,"成功"),
    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(2,"列目不存在"),
    COLLECTION_NOT_EXIST(3,"收藏不存在"),
    COLLECTION_STATUS_ERROR(4,"收藏状态不正确"),
    COLLECTION_UPDATE_ERROR(5,"收藏更新失败"),
    COLLECTION_OWNER_ERROR(6,"收藏的userid不存在"),
    COLLECTION_CANCEL_SUCCESS(7,"取消收藏成功"),
    PRODUCT_STATUS_ERROR(8,"商品状态错误"),
    Login_FAIL(9,"登录失败"),
    Login_SUCCESS(10,"登录成功"),
    COLLECTIONDETAIL_NOT_EXIST(11,"收藏详情不存在"),
    COLLECTION_INFO_EMPTY(12,"收藏内容为空"),
    COLLECTION_UPDATE_SUCCESS(13,"收藏成功"),




    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
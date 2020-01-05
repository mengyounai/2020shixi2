package com.example.demo.util;

import com.example.demo.enums.CodeEnum;

public class EnumUtil {

    public static <T extends CodeEnum> T getEnumbyCode(Integer code,Class<T> enumClass){
        for (T each: enumClass.getEnumConstants()){
            if (each.getCode().equals(code)){
                return each;
            }
        }
        return null;
    }
}

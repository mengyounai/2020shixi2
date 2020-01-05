package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;
import lombok.Getter;

@Getter
public class SellException extends RuntimeException  {

    private Integer code;

    public SellException(Integer code,String message){
        super(message);
        this.code=code;
    }

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}



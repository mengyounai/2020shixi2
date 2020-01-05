package com.example.demo.util;

import java.util.Random;

public class KeyUtil {

    public static synchronized String genUniquKey(){

        Random random=new Random();
        return System.currentTimeMillis()+
                String.valueOf(random.nextInt(900000)+100000);

    }
}

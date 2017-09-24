package com.vcooline.crm.common.utils;

import java.util.Random;

/**
 * 随机数辅助类
 * Created by xinbaojian on 15/7/17.
 */
public class RandomUtils {

    public static int RandomByInterval(int min,int max){
        return  (int)Math.round(Math.random()*(max-min)+min);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int a =RandomByInterval(0,2);
            if (a>2)
                System.out.println("-------" + a);
        }

    }
}

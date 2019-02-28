package com.mhdss.shop.util;

public class PhoneUtil {

    public static String queryRandom() {
        int a = (int) (100000 + Math.random() * 900000);

        return String.valueOf(a);
    }

}

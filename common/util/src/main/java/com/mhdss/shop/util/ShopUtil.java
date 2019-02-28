package com.mhdss.shop.util;

public class ShopUtil {

    public static String generateShopSn(Long id) {

        return "sk" + String.valueOf(id);
    }

    public static String generateShopCode(){

        return UUIDUtil.random();
    }
}

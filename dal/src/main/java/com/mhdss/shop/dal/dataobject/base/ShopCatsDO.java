package com.mhdss.shop.dal.dataobject.base;

import com.mhdss.shop.dal.dataobject.BaseDO;

public class ShopCatsDO extends BaseDO {
    private Long shopId;

    private String catId;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }
}
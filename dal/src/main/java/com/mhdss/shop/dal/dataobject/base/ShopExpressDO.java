package com.mhdss.shop.dal.dataobject.base;

import com.mhdss.shop.dal.dataobject.BaseDO;

import java.math.BigDecimal;

public class ShopExpressDO extends BaseDO {
    private Long shopId;

    private Long expressId;

    private BigDecimal price;

    private Byte isFree;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getExpressId() {
        return expressId;
    }

    public void setExpressId(Long expressId) {
        this.expressId = expressId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Byte getIsFree() {
        return isFree;
    }

    public void setIsFree(Byte isFree) {
        this.isFree = isFree;
    }
}
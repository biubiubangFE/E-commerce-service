package com.mhdss.shop.dal.dataobject.goods;

import com.mhdss.shop.dal.dataobject.BaseDO;

public class GoodsSpecsDO extends BaseDO {
    private Long goodsId;

    private String name;

    private Long imgFileId;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getImgFileId() {
        return imgFileId;
    }

    public void setImgFileId(Long imgFileId) {
        this.imgFileId = imgFileId;
    }
}
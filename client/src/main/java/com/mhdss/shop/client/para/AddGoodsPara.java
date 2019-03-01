package com.mhdss.shop.client.para;

import java.math.BigDecimal;

public class AddGoodsPara {

    private Long userId;

    private Long goodsCatsId;

    private String goodsName;

    private String keyWord;

    private String goodsDesc;

    private Long imgFileId;

    private BigDecimal price;

    private BigDecimal cost;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsCatsId() {
        return goodsCatsId;
    }

    public void setGoodsCatsId(Long goodsCatsId) {
        this.goodsCatsId = goodsCatsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public Long getImgFileId() {
        return imgFileId;
    }

    public void setImgFileId(Long imgFileId) {
        this.imgFileId = imgFileId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}

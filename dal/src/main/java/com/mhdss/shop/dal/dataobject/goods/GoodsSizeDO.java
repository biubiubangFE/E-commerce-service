package com.mhdss.shop.dal.dataobject.goods;

import com.mhdss.shop.dal.dataobject.BaseDO;

import java.math.BigDecimal;

public class GoodsSizeDO extends BaseDO {
    private String name;

    private Long shopId;

    private Long goodsId;

    private Long goodsSpecsId;

    private BigDecimal cost;

    private BigDecimal price;

    private Integer stock;

    private Integer saleNum;

    private Integer warnStock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsSpecsId() {
        return goodsSpecsId;
    }

    public void setGoodsSpecsId(Long goodsSpecsId) {
        this.goodsSpecsId = goodsSpecsId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getWarnStock() {
        return warnStock;
    }

    public void setWarnStock(Integer warnStock) {
        this.warnStock = warnStock;
    }
}
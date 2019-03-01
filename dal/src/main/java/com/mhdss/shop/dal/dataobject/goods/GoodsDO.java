package com.mhdss.shop.dal.dataobject.goods;

import com.mhdss.shop.dal.dataobject.BaseDO;

import java.math.BigDecimal;

public class GoodsDO extends BaseDO {
    private Long goodsCatsId;

    private Long shopId;

    private String goodsName;

    private String proNo;

    private String keyWord;

    private String goodsDesc;

    private Long imgFileId;

    private BigDecimal price;

    private BigDecimal cost;

    private Integer visitNum;

    private Integer appraiseNum;

    private Byte isSpec;

    private Byte isSale;

    private Byte isHot;

    private Byte isNew;

    private Byte isRecom;

    public Long getGoodsCatsId() {
        return goodsCatsId;
    }

    public void setGoodsCatsId(Long goodsCatsId) {
        this.goodsCatsId = goodsCatsId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getProNo() {
        return proNo;
    }

    public void setProNo(String proNo) {
        this.proNo = proNo;
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

    public Integer getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }

    public Integer getAppraiseNum() {
        return appraiseNum;
    }

    public void setAppraiseNum(Integer appraiseNum) {
        this.appraiseNum = appraiseNum;
    }

    public Byte getIsSpec() {
        return isSpec;
    }

    public void setIsSpec(Byte isSpec) {
        this.isSpec = isSpec;
    }

    public Byte getIsSale() {
        return isSale;
    }

    public void setIsSale(Byte isSale) {
        this.isSale = isSale;
    }

    public Byte getIsHot() {
        return isHot;
    }

    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    public Byte getIsNew() {
        return isNew;
    }

    public void setIsNew(Byte isNew) {
        this.isNew = isNew;
    }

    public Byte getIsRecom() {
        return isRecom;
    }

    public void setIsRecom(Byte isRecom) {
        this.isRecom = isRecom;
    }
}
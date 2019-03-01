package com.mhdss.shop.dal.dataobject.goods;

import com.mhdss.shop.dal.dataobject.BaseDO;

public class AttributesDO extends BaseDO {
    private Long goodsCatId;

    private Long goodsCatParentId;

    private String attrName;

    private Integer attrSort;

    private Byte isShow;

    public Long getGoodsCatId() {
        return goodsCatId;
    }

    public void setGoodsCatId(Long goodsCatId) {
        this.goodsCatId = goodsCatId;
    }

    public Long getGoodsCatParentId() {
        return goodsCatParentId;
    }

    public void setGoodsCatParentId(Long goodsCatParentId) {
        this.goodsCatParentId = goodsCatParentId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Integer getAttrSort() {
        return attrSort;
    }

    public void setAttrSort(Integer attrSort) {
        this.attrSort = attrSort;
    }

    public Byte getIsShow() {
        return isShow;
    }

    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }
}
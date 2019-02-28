package com.mhdss.shop.dal.dataobject.base;

import com.mhdss.shop.dal.dataobject.BaseDO;

public class GoodsCatsDO extends BaseDO {
    private Long parentId;

    private String catName;

    private Byte isShow;

    private Byte isFloor;

    private Integer catSort;

    private Byte garde;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Byte getIsShow() {
        return isShow;
    }

    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    public Byte getIsFloor() {
        return isFloor;
    }

    public void setIsFloor(Byte isFloor) {
        this.isFloor = isFloor;
    }

    public Integer getCatSort() {
        return catSort;
    }

    public void setCatSort(Integer catSort) {
        this.catSort = catSort;
    }

    public Byte getGarde() {
        return garde;
    }

    public void setGarde(Byte garde) {
        this.garde = garde;
    }
}
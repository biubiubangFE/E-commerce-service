package com.mhdss.shop.dal.dataobject.goods;

import com.mhdss.shop.dal.dataobject.BaseDO;

public class GoodsShopCarDO extends BaseDO {
    private Long wxUserId;

    private Long goodsId;

    private Integer num;

    private Byte isCheck;

    public Long getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(Long wxUserId) {
        this.wxUserId = wxUserId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Byte getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Byte isCheck) {
        this.isCheck = isCheck;
    }
}
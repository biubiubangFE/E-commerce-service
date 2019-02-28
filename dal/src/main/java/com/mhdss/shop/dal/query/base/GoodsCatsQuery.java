package com.mhdss.shop.dal.query.base;

import com.mhdss.shop.dal.query.AbstractQuery;

public class GoodsCatsQuery extends AbstractQuery {

    private Byte isShow;

    private Byte status;

    public Byte getIsShow() {
        return isShow;
    }

    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
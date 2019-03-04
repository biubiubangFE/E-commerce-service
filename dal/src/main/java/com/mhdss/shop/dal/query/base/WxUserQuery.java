package com.mhdss.shop.dal.query.base;

import com.mhdss.shop.dal.query.AbstractQuery;

public class WxUserQuery extends AbstractQuery {

    private String sessionkey;

    private Byte status;

    public String getSessionkey() {
        return sessionkey;
    }

    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
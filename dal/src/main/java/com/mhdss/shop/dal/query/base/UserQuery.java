package com.mhdss.shop.dal.query.base;

import com.mhdss.shop.dal.query.AbstractQuery;

public class UserQuery extends AbstractQuery {

    private String userPhone;

    private String loginPwd;

    private Byte status;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
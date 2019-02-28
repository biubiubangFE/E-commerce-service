package com.mhdss.shop.dal.dataobject.base;

import com.mhdss.shop.dal.dataobject.BaseDO;

public class PhoneCheckDO extends BaseDO {
    private String userPhone;

    private String checkCode;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
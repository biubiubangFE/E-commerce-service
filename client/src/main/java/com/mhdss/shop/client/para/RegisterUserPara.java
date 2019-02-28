package com.mhdss.shop.client.para;

import org.apache.commons.lang3.StringUtils;

public class RegisterUserPara {

    private String userPhone;

    private String loginPwd;

    private String checkCode;

    public boolean check() {

        if (StringUtils.isAnyBlank(userPhone, loginPwd, checkCode)) {
            return false;
        }
        return true;
    }

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

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}

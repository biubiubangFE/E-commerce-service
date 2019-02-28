package com.mhdss.shop.client.dto;

public class AuthAgent {

    private long userId;

    private long wxUserId;

    private String ip;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(long wxUserId) {
        this.wxUserId = wxUserId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

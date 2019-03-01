package com.mhdss.shop.client.para;


public class UpdateShopPara {

    private Long userId;
    private String shopName;
    private String shopkeeper;
    private String telephone;
    private Long shopImgFileId;
    private Long serviceStartTime;
    private Long serviceEndTime;
    private Byte shopAtive;
    private Byte isInvoice;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopkeeper() {
        return shopkeeper;
    }

    public void setShopkeeper(String shopkeeper) {
        this.shopkeeper = shopkeeper;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getShopImgFileId() {
        return shopImgFileId;
    }

    public void setShopImgFileId(Long shopImgFileId) {
        this.shopImgFileId = shopImgFileId;
    }

    public Long getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(Long serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public Long getServiceEndTime() {
        return serviceEndTime;
    }

    public void setServiceEndTime(Long serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    public Byte getShopAtive() {
        return shopAtive;
    }

    public void setShopAtive(Byte shopAtive) {
        this.shopAtive = shopAtive;
    }

    public Byte getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(Byte isInvoice) {
        this.isInvoice = isInvoice;
    }
}

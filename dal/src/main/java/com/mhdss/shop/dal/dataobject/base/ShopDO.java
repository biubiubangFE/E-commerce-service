package com.mhdss.shop.dal.dataobject.base;

import com.mhdss.shop.dal.dataobject.BaseDO;

import java.math.BigDecimal;
import java.util.Date;

public class ShopDO extends BaseDO {
    private String shopName;

    private String shopSn;

    private String shopCode;

    private Long userId;

    private Byte isSelf;

    private String shopkeeper;

    private String 	telephone;

    private String shopImg;

    private Byte isInvoice;

    private String invoiceRemarks;

    private Long serviceStartTime;

    private Long serviceEndTime;

    private Byte shopAtive;

    private Byte shopStatus;

    private String statusDesc;

    private BigDecimal shopMoney;

    private BigDecimal lockMoney;

    private Integer noSettledOrderNum;

    private BigDecimal noSettledOrderFee;

    private BigDecimal payMentMoney;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopSn() {
        return shopSn;
    }

    public void setShopSn(String shopSn) {
        this.shopSn = shopSn;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public Byte getShopStatus() {
        return shopStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(Byte isSelf) {
        this.isSelf = isSelf;
    }

    public String getShopkeeper() {
        return shopkeeper;
    }

    public void setShopkeeper(String shopkeeper) {
        this.shopkeeper = shopkeeper;
    }

    public String getTelephone() {
        return 	telephone;
    }

    public void setTelephone(String 	telephone) {
        this.	telephone = 	telephone;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public Byte getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(Byte isInvoice) {
        this.isInvoice = isInvoice;
    }

    public void setShopStatus(Byte shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getInvoiceRemarks() {
        return invoiceRemarks;
    }

    public void setInvoiceRemarks(String invoiceRemarks) {
        this.invoiceRemarks = invoiceRemarks;
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


    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public BigDecimal getShopMoney() {
        return shopMoney;
    }

    public void setShopMoney(BigDecimal shopMoney) {
        this.shopMoney = shopMoney;
    }

    public BigDecimal getLockMoney() {
        return lockMoney;
    }

    public void setLockMoney(BigDecimal lockMoney) {
        this.lockMoney = lockMoney;
    }

    public Integer getNoSettledOrderNum() {
        return noSettledOrderNum;
    }

    public void setNoSettledOrderNum(Integer noSettledOrderNum) {
        this.noSettledOrderNum = noSettledOrderNum;
    }

    public BigDecimal getNoSettledOrderFee() {
        return noSettledOrderFee;
    }

    public void setNoSettledOrderFee(BigDecimal noSettledOrderFee) {
        this.noSettledOrderFee = noSettledOrderFee;
    }

    public BigDecimal getPayMentMoney() {
        return payMentMoney;
    }

    public void setPayMentMoney(BigDecimal payMentMoney) {
        this.payMentMoney = payMentMoney;
    }
}
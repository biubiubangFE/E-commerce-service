package com.mhdss.shop.client.constants;

public enum ShopShopStatus {

    //门店状态	-2:已停止 -1:拒绝 0：未审核 1:已审核
    STOP((byte) -2, "自营"),
    REFUSE((byte) -1, "拒绝"),
    UN_CHECKED((byte) 0, "未审核"),
    CHECKED((byte) 1, "已审核"),
    UN_PERFECT_INFO((byte) 2, "未完善信息");

    private final Byte status;
    private final String desc;

    ShopShopStatus(Byte status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static ShopShopStatus getStatus(Byte status) {

        for (ShopShopStatus shopStatus : ShopShopStatus.values()) {
            if (status.equals(shopStatus.getStatus())) {
                return shopStatus;
            }
        }
        throw new IllegalArgumentException();
    }

    public Byte getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}

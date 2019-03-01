package com.mhdss.shop.client.constants;

public enum GoodsIsSale {

    YES((byte) 1, "是"),
    NO((byte) 0, "否");

    private final Byte status;
    private final String desc;

    GoodsIsSale(Byte status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static GoodsIsSale getStatus(Byte status) {

        for (GoodsIsSale isSale : GoodsIsSale.values()) {
            if (status.equals(isSale.getStatus())) {
                return isSale;
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

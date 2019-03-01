package com.mhdss.shop.client.constants;

public enum GoodsIsRecom {

    YES((byte) 1, "是"),
    NO((byte) 0, "否");

    private final Byte status;
    private final String desc;

    GoodsIsRecom(Byte status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static GoodsIsRecom getStatus(Byte status) {

        for (GoodsIsRecom isRecom : GoodsIsRecom.values()) {
            if (status.equals(isRecom.getStatus())) {
                return isRecom;
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

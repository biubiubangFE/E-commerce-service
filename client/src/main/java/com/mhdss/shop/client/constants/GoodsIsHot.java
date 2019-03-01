package com.mhdss.shop.client.constants;

public enum GoodsIsHot {

    YES((byte) 1, "是"),
    NO((byte) 0, "否");

    private final Byte status;
    private final String desc;

    GoodsIsHot(Byte status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static GoodsIsHot getStatus(Byte status) {

        for (GoodsIsHot isHot : GoodsIsHot.values()) {
            if (status.equals(isHot.getStatus())) {
                return isHot;
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

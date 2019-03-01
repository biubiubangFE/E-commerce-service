package com.mhdss.shop.client.constants;

public enum  GoodsIsNew {

    YES((byte) 1, "是"),
    NO((byte) 0, "否");

    private final Byte status;
    private final String desc;

    GoodsIsNew(Byte status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static GoodsIsNew getStatus(Byte status) {

        for (GoodsIsNew isNew : GoodsIsNew.values()) {
            if (status.equals(isNew.getStatus())) {
                return isNew;
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

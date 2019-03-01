package com.mhdss.shop.client.constants;

public enum GoodsIsSpec {

    YES((byte) 1, "是"),
    NO((byte) 0, "否");

    private final Byte status;
    private final String desc;

    GoodsIsSpec(Byte status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static GoodsIsSpec getStatus(Byte status) {

        for (GoodsIsSpec isSpec : GoodsIsSpec.values()) {
            if (status.equals(isSpec.getStatus())) {
                return isSpec;
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

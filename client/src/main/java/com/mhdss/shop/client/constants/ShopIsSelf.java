package com.mhdss.shop.client.constants;

public enum ShopIsSelf {

    PROPRIETARY((byte) 1, "自营"),
    NON_PROPRIETARY((byte) 0, "非自营");

    private final Byte status;
    private final String desc;

    ShopIsSelf(Byte status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static ShopIsSelf getStatus(Byte status) {

        for (ShopIsSelf isSelf : ShopIsSelf.values()) {
            if (status.equals(isSelf.getStatus())) {
                return isSelf;
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

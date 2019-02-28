package com.mhdss.shop.client.constants;

public enum  GoodsIsShow {

    SHOW((byte) 1, "显示"),
    HIDE((byte) 0, "隐藏");

    private final Byte status;
    private final String desc;

    GoodsIsShow(Byte status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static GoodsIsShow getStatus(Byte status) {

        for (GoodsIsShow isShow : GoodsIsShow.values()) {
            if (status.equals(isShow.getStatus())) {
                return isShow;
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

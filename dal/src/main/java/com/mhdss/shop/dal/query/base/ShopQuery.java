package com.mhdss.shop.dal.query.base;

import com.mhdss.shop.dal.query.AbstractQuery;

public class ShopQuery extends AbstractQuery {

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
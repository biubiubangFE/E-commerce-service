package com.mhdss.shop.dal.query.base;

import com.mhdss.shop.dal.query.AbstractQuery;

public class ShopQuery extends AbstractQuery {

    private Long userId;

    private Long parentId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
package com.mhdss.shop.dal.dao.base.impl;

import com.mhdss.shop.dal.dao.BaseDAOImpl;
import com.mhdss.shop.dal.dao.base.ShopDAO;
import com.mhdss.shop.dal.dataobject.base.ShopDO;
import com.mhdss.shop.dal.query.base.ShopQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDAOImpl extends BaseDAOImpl<ShopDO, ShopQuery> implements ShopDAO {

    @Override
    protected String getNameSpace() {
        return ShopDAO.class.getName();
    }
}
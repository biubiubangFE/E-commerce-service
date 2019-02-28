package com.mhdss.shop.dal.dao.base.impl;

import com.mhdss.shop.dal.dao.BaseDAOImpl;
import com.mhdss.shop.dal.dao.base.ShopCatsDAO;
import com.mhdss.shop.dal.dataobject.base.ShopCatsDO;
import com.mhdss.shop.dal.query.base.ShopCatsQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ShopCatsDAOImpl extends BaseDAOImpl<ShopCatsDO, ShopCatsQuery> implements ShopCatsDAO {

    @Override
    protected String getNameSpace() {
        return ShopCatsDAO.class.getName();
    }
}
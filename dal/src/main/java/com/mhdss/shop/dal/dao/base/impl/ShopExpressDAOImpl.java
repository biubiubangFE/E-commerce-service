package com.mhdss.shop.dal.dao.base.impl;

import com.mhdss.shop.dal.dao.BaseDAOImpl;
import com.mhdss.shop.dal.dao.base.ShopExpressDAO;
import com.mhdss.shop.dal.dataobject.base.ShopExpressDO;
import com.mhdss.shop.dal.query.base.ShopExpressQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ShopExpressDAOImpl extends BaseDAOImpl<ShopExpressDO, ShopExpressQuery> implements ShopExpressDAO {

    @Override
    protected String getNameSpace() {
        return ShopExpressDAO.class.getName();
    }
}
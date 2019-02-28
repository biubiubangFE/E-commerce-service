package com.mhdss.shop.dal.dao.base.impl;

import com.mhdss.shop.dal.dao.BaseDAOImpl;
import com.mhdss.shop.dal.dao.base.GoodsCatsDAO;
import com.mhdss.shop.dal.dataobject.base.GoodsCatsDO;
import com.mhdss.shop.dal.query.base.GoodsCatsQuery;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsCatsDAOImpl extends BaseDAOImpl<GoodsCatsDO, GoodsCatsQuery> implements GoodsCatsDAO {

    @Override
    protected String getNameSpace() {
        return GoodsCatsDAO.class.getName();
    }
}
package com.mhdss.shop.dal.dao.base.impl;

import com.mhdss.shop.dal.dao.BaseDAOImpl;
import com.mhdss.shop.dal.dao.base.ExpressDAO;
import com.mhdss.shop.dal.dataobject.base.ExpressDO;
import com.mhdss.shop.dal.query.base.ExpressQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ExpressDAOImpl extends BaseDAOImpl<ExpressDO, ExpressQuery> implements ExpressDAO {

    @Override
    protected String getNameSpace() {
        return ExpressDAO.class.getName();
    }
}
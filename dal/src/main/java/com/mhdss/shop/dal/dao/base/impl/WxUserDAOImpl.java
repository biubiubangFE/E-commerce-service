package com.mhdss.shop.dal.dao.base.impl;

import com.mhdss.shop.dal.dao.BaseDAOImpl;
import com.mhdss.shop.dal.dao.base.WxUserDAO;
import com.mhdss.shop.dal.dataobject.base.WxUserDO;
import com.mhdss.shop.dal.query.base.WxUserQuery;
import org.springframework.stereotype.Repository;

@Repository
public class WxUserDAOImpl extends BaseDAOImpl<WxUserDO, WxUserQuery> implements WxUserDAO {

    @Override
    protected String getNameSpace() {
        return WxUserDAO.class.getName();
    }
}
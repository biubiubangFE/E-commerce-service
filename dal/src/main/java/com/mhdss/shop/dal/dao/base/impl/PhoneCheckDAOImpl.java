package com.mhdss.shop.dal.dao.base.impl;

import com.mhdss.shop.dal.dao.BaseDAOImpl;
import com.mhdss.shop.dal.dao.base.PhoneCheckDAO;
import com.mhdss.shop.dal.dataobject.base.PhoneCheckDO;
import com.mhdss.shop.dal.query.base.PhoneCheckQuery;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneCheckDAOImpl extends BaseDAOImpl<PhoneCheckDO, PhoneCheckQuery> implements PhoneCheckDAO {

    @Override
    protected String getNameSpace() {
        return PhoneCheckDAO.class.getName();
    }
}
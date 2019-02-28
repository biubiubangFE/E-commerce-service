package com.mhdss.shop.dal.dao.base.impl;

import com.mhdss.shop.dal.dao.BaseDAOImpl;
import com.mhdss.shop.dal.dao.base.UserDAO;
import com.mhdss.shop.dal.dataobject.base.UserDO;
import com.mhdss.shop.dal.query.base.UserQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends BaseDAOImpl<UserDO, UserQuery> implements UserDAO {

    @Override
    protected String getNameSpace() {
        return UserDAO.class.getName();
    }
}
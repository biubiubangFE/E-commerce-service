package com.mhdss.shop.dal.dao;

import com.mhdss.shop.dal.dataobject.BaseDO;
import com.mhdss.shop.dal.query.AbstractQuery;
import com.mhdss.shop.dal.query.PagedList;

public interface BaseDAO<T extends BaseDO, QUERY extends AbstractQuery> extends MapperDAO<T, QUERY> {
    int insertUnique(T t);

    int updateByQuery(T t, QUERY query);

    T selectByQuery(QUERY query);

    PagedList<T> selectPage(QUERY query);
}
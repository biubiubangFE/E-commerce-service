package com.mhdss.shop.core.service.goods;

import com.mhdss.shop.client.constants.*;
import com.mhdss.shop.client.para.AddGoodsPara;
import com.mhdss.shop.client.service.goods.GoodsService;
import com.mhdss.shop.dal.dao.base.ShopDAO;
import com.mhdss.shop.dal.dao.goods.GoodsDAO;
import com.mhdss.shop.dal.dataobject.base.ShopDO;
import com.mhdss.shop.dal.dataobject.goods.GoodsDO;
import com.mhdss.shop.dal.query.base.ShopQuery;
import com.mhdss.shop.util.DateUtil;
import com.mhdss.shop.util.GoodsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDAO goodsDAO;
    @Autowired
    private ShopDAO shopDAO;

    @Override
    public Boolean addGoods(AddGoodsPara para) {

        Long userId = para.getUserId();
        ShopQuery shopQuery = new ShopQuery();
        shopQuery.setUserId(userId);
        ShopDO shopDO = shopDAO.selectByQuery(shopQuery);
        if (null == shopDO) {
            return false;
        }

        GoodsDO goodsDO = new GoodsDO();
        goodsDO.setShopId(shopDO.getId());
        goodsDO.setCost(para.getCost());
        goodsDO.setGoodsDesc(para.getGoodsDesc());
        goodsDO.setGoodsCatsId(para.getGoodsCatsId());
        goodsDO.setGoodsName(para.getGoodsName());
        goodsDO.setImgFileId(para.getImgFileId());
        goodsDO.setCreateTime(DateUtil.getCurrentTimeStamp());
        goodsDO.setStatus(BaseStatus.NORMAL.getStatus());
        goodsDO.setIsHot(GoodsIsHot.NO.getStatus());
        goodsDO.setIsNew(GoodsIsNew.NO.getStatus());
        goodsDO.setIsSale(GoodsIsSale.NO.getStatus());
        goodsDO.setIsSpec(GoodsIsSpec.NO.getStatus());
        goodsDO.setProNo(GoodsUtil.queryProNO());
        goodsDAO.insert(goodsDO);
        return null;
    }
}

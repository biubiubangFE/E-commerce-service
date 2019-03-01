package com.mhdss.shop.core.service.admin;

import com.mhdss.shop.client.constants.BaseStatus;
import com.mhdss.shop.client.constants.GoodsIsShow;
import com.mhdss.shop.client.dto.CatsDTO;
import com.mhdss.shop.client.dto.ShopDTO;
import com.mhdss.shop.client.para.UpdateShopPara;
import com.mhdss.shop.client.service.admin.ShopService;
import com.mhdss.shop.core.convert.ShopConvert;
import com.mhdss.shop.dal.dao.base.GoodsCatsDAO;
import com.mhdss.shop.dal.dao.base.ShopDAO;
import com.mhdss.shop.dal.dataobject.base.GoodsCatsDO;
import com.mhdss.shop.dal.dataobject.base.ShopDO;
import com.mhdss.shop.dal.query.base.GoodsCatsQuery;
import com.mhdss.shop.dal.query.base.ShopQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private GoodsCatsDAO goodsCatsDAO;

    @Autowired
    private ShopDAO shopDAO;

    @Override
    public List<CatsDTO> queryShopCatsList() {

        GoodsCatsQuery goodsCatsQuery = new GoodsCatsQuery();
        goodsCatsQuery.setIsShow(GoodsIsShow.SHOW.getStatus());
        goodsCatsQuery.setStatus(BaseStatus.NORMAL.getStatus());
        List<GoodsCatsDO> goodsCatsDOS = goodsCatsDAO.selectList(goodsCatsQuery);

        List<GoodsCatsDO> oneCatsList = goodsCatsDOS.stream().filter(catsDO -> catsDO.getParentId().equals(-1L)).collect(Collectors.toList());
        oneCatsList.sort(Comparator.comparingLong(GoodsCatsDO::getCatSort));
        List<CatsDTO> oneCatsDTOList = new ArrayList<>();

        for (GoodsCatsDO oneSorts : oneCatsList) {
            CatsDTO oneCatsDTO = new CatsDTO();
            oneCatsDTO.setCatName(oneSorts.getCatName());
            oneCatsDTO.setGarde(oneSorts.getGarde());
            oneCatsDTO.setId(oneSorts.getId());
            oneCatsDTO.setParentId(oneSorts.getParentId());

            List<GoodsCatsDO> twoCatsList = goodsCatsDOS.stream().filter(catsDO -> catsDO.getParentId().equals(oneSorts.getId())).collect(Collectors.toList());
            twoCatsList.sort(Comparator.comparingLong(GoodsCatsDO::getCatSort));
            List<CatsDTO> twoCatsDTOList = new ArrayList<>();
            for (GoodsCatsDO twoSorts : twoCatsList) {

                CatsDTO twoCatsDTO = new CatsDTO();
                twoCatsDTO.setCatName(twoSorts.getCatName());
                twoCatsDTO.setGarde(twoSorts.getGarde());
                twoCatsDTO.setId(twoSorts.getId());
                twoCatsDTO.setParentId(twoSorts.getParentId());

                List<GoodsCatsDO> threeCatsList = goodsCatsDOS.stream().filter(catsDO -> catsDO.getParentId().equals(twoSorts.getId())).collect(Collectors.toList());
                threeCatsList.sort(Comparator.comparingLong(GoodsCatsDO::getCatSort));
                List<CatsDTO> threeCatsDTOList = new ArrayList<>();
                for (GoodsCatsDO threeSorts : threeCatsList) {
                    CatsDTO threeCatsDTO = new CatsDTO();
                    threeCatsDTO.setCatName(threeSorts.getCatName());
                    threeCatsDTO.setGarde(threeSorts.getGarde());
                    threeCatsDTO.setId(threeSorts.getId());
                    threeCatsDTO.setParentId(threeSorts.getParentId());

                    threeCatsDTOList.add(threeCatsDTO);
                }
                twoCatsDTO.setCatsList(threeCatsDTOList);
                twoCatsDTOList.add(twoCatsDTO);

            }
            oneCatsDTO.setCatsList(twoCatsDTOList);
            oneCatsDTOList.add(oneCatsDTO);
        }
        return oneCatsDTOList;
    }

    @Override
    public Boolean updateShopInfo(UpdateShopPara updateShopPara) {

        Long userId = updateShopPara.getUserId();

        if (null == userId || userId == 0) {
            return false;
        }

        //通过用户查找店铺
        ShopQuery shopQuery = new ShopQuery();
        shopQuery.setUserId(userId);
        ShopDO shopDO = shopDAO.selectByQuery(shopQuery);

        if (null == shopDO) {
            return false;
        }
        Long shopId = shopDO.getId();

        ShopDO updateShopDO = new ShopDO();
        updateShopDO.setId(shopId);
        updateShopDO.setShopName(updateShopPara.getShopName());
        updateShopDO.setShopAtive(updateShopPara.getShopAtive());
        updateShopDO.setShopkeeper(updateShopPara.getShopkeeper());
        updateShopDO.setTelephone(updateShopPara.getTelephone());
        updateShopDO.setServiceStartTime(updateShopPara.getServiceStartTime());
        updateShopDO.setServiceEndTime(updateShopPara.getServiceEndTime());
        updateShopDO.setIsInvoice(updateShopPara.getIsInvoice());
        updateShopDO.setShopImgFileId(updateShopPara.getShopImgFileId());
        shopDAO.updateById(updateShopDO);
        return true;
    }

    @Override
    public ShopDTO queryShopInfo(Long userId) {
        ShopQuery shopQuery = new ShopQuery();
        shopQuery.setUserId(userId);
        ShopDO shopDO = shopDAO.selectByQuery(shopQuery);
        ShopDTO shopDTO = ShopConvert.do2dto(shopDO);

        return shopDTO;
    }
}

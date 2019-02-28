package com.mhdss.shop.client.service.admin;

import com.mhdss.shop.client.dto.CatsDTO;
import com.mhdss.shop.client.dto.ShopDTO;
import com.mhdss.shop.client.para.UpdateShopPara;

import java.util.List;

public interface ShopService {

    List<CatsDTO> queryShopCatsList();

    Boolean updateShopInfo(UpdateShopPara updateShopPara);

    ShopDTO queryShopInfo(Long userId);
}

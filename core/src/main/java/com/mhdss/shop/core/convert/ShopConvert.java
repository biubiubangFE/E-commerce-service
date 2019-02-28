package com.mhdss.shop.core.convert;

import com.mhdss.shop.client.dto.ShopDTO;
import com.mhdss.shop.dal.dataobject.base.ShopDO;

public class ShopConvert {

    public static ShopDTO do2dto(ShopDO shopDO) {

        if (null == shopDO) {
            return null;
        }
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setId(shopDO.getId());
        shopDTO.setInvoiceRemarks(shopDO.getInvoiceRemarks());
        return shopDTO;

    }
}

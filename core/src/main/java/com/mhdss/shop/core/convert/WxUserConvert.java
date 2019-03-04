package com.mhdss.shop.core.convert;

import com.mhdss.shop.client.dto.WxUserDTO;
import com.mhdss.shop.dal.dataobject.base.WxUserDO;

public class WxUserConvert {

    public static WxUserDTO do2DTO(WxUserDO userDO) {

        if (null == userDO) {
            return null;
        }

        WxUserDTO dto = new WxUserDTO();
        dto.setId(userDO.getId());
        dto.setOpenId(userDO.getOpenId());
        dto.setNickName(userDO.getNickName());
        dto.setAvatarUrl(userDO.getAvatarUrl());
        return dto;
    }
}

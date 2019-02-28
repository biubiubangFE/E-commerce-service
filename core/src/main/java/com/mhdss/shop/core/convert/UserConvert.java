package com.mhdss.shop.core.convert;

import com.mhdss.shop.client.dto.UserDTO;
import com.mhdss.shop.dal.dataobject.base.UserDO;

public class UserConvert {

    public static UserDTO DO2DTO(UserDO userDO) {

        if (null == userDO) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setUserPhone(userDO.getUserPhone());
        userDTO.setUserType(userDO.getUserType());
        return userDTO;
    }
}

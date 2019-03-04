package com.mhdss.shop.client.service.admin;

import com.mhdss.shop.client.dto.UserDTO;
import com.mhdss.shop.client.dto.WxUserDTO;

import javax.servlet.http.Cookie;

public interface SessionService {

    Cookie getCookie(String sessionKey);

    UserDTO queryUserBySessionKey(String sessionKey);

    WxUserDTO queryWxUserBySessionKey(String sessionKey);

}

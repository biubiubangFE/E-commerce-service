package com.mhdss.shop.client.service.admin;

import javax.servlet.http.Cookie;

public interface SessionService {

    Cookie getCookie(String sessionKey);

}

package com.mhdss.shop.core.service.admin;

import com.mhdss.shop.client.service.admin.SessionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.Cookie;

public class SessionServiceImpl implements SessionService {

    @Value("${shop.passport.domain}")
    private String domain;
    @Value("${shop.auth.cookieKey}")
    private String cookieName;

    @Override
    public Cookie getCookie(String sessionId) {

        Cookie cookie = new Cookie(cookieName, sessionId);
        if (StringUtils.isNotBlank(domain)) {
            cookie.setDomain(domain);
        }
        cookie.setMaxAge(60 * 60 * 24 * 180);
        cookie.setHttpOnly(false);
        cookie.setSecure(false);
        cookie.setPath("/");
        return cookie;
    }
}

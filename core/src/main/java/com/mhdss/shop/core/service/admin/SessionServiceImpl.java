package com.mhdss.shop.core.service.admin;

import com.mhdss.shop.client.constants.BaseStatus;
import com.mhdss.shop.client.dto.UserDTO;
import com.mhdss.shop.client.dto.WxUserDTO;
import com.mhdss.shop.client.service.admin.SessionService;
import com.mhdss.shop.core.convert.UserConvert;
import com.mhdss.shop.core.convert.WxUserConvert;
import com.mhdss.shop.dal.dao.base.UserDAO;
import com.mhdss.shop.dal.dao.base.WxUserDAO;
import com.mhdss.shop.dal.dataobject.base.UserDO;
import com.mhdss.shop.dal.dataobject.base.WxUserDO;
import com.mhdss.shop.dal.query.base.UserQuery;
import com.mhdss.shop.dal.query.base.WxUserQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;

@Service
public class SessionServiceImpl implements SessionService {

    @Value("${shop.passport.domain}")
    private String domain;
    @Value("${shop.auth.cookieName}")
    private String cookieName;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private WxUserDAO wxUserDAO;


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

    @Override
    public UserDTO queryUserBySessionKey(String sessionKey) {
        UserQuery userQuery = new UserQuery();
        userQuery.setCookieKey(sessionKey);
        userQuery.setStatus(BaseStatus.NORMAL.getStatus());

        UserDO userDO = userDAO.selectByQuery(userQuery);
        if (null == userDO) {
            return null;
        }

        return UserConvert.do2DTO(userDO);
    }

    @Override
    public WxUserDTO queryWxUserBySessionKey(String sessionKey) {

        WxUserQuery userQuery = new WxUserQuery();
        userQuery.setSessionkey(sessionKey);
        userQuery.setStatus(BaseStatus.NORMAL.getStatus());
        WxUserDO wxUserDO = wxUserDAO.selectByQuery(userQuery);
        if (null == wxUserDO) {
            return null;
        }

        return WxUserConvert.do2DTO(wxUserDO);
    }


}

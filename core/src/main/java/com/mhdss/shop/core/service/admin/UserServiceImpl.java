package com.mhdss.shop.core.service.admin;

import com.mhdss.shop.client.constants.BaseStatus;
import com.mhdss.shop.client.constants.Constants;
import com.mhdss.shop.client.constants.ShopIsSelf;
import com.mhdss.shop.client.dto.UserDTO;
import com.mhdss.shop.client.service.admin.SessionService;
import com.mhdss.shop.client.service.admin.UserService;
import com.mhdss.shop.core.convert.UserConvert;
import com.mhdss.shop.dal.dao.base.PhoneCheckDAO;
import com.mhdss.shop.dal.dao.base.ShopDAO;
import com.mhdss.shop.dal.dao.base.UserDAO;
import com.mhdss.shop.dal.dataobject.base.PhoneCheckDO;
import com.mhdss.shop.dal.dataobject.base.ShopDO;
import com.mhdss.shop.dal.dataobject.base.UserDO;
import com.mhdss.shop.dal.query.base.PhoneCheckQuery;
import com.mhdss.shop.dal.query.base.UserQuery;
import com.mhdss.shop.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private PhoneCheckDAO phoneCheckDAO;
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private SessionService sessionService;
    @Autowired
    private ShopDAO shopDAO;

    @Override
    public boolean register(String userPhone, String loginPwd) {

        //
        String saltKey = UUIDUtil.random();

        String saltPwd = MD5Util.getMD5String(loginPwd + saltKey);

        UserDO userDO = new UserDO();
        userDO.setLoginSalt(saltKey);
        userDO.setUserPhone(userPhone);
        userDO.setLoginPwd(saltPwd);
        userDO.setStatus(BaseStatus.NORMAL.getStatus());
        int tag = userDAO.insertUnique(userDO);
        if (0 == tag) {
            return false;
        }
        ShopDO shopDO = new ShopDO();
        shopDO.setShopSn(ShopUtil.generateShopSn(userDO.getId()));
        shopDO.setShopCode(ShopUtil.generateShopCode());
        shopDO.setUserId(userDO.getId());
        shopDO.setIsSelf(ShopIsSelf.NON_PROPRIETARY.getStatus());
        shopDO.setNoSettledOrderFee(new BigDecimal(0));
        shopDO.setLockMoney(new BigDecimal(0));
        shopDO.setTelephone(userPhone);
        shopDO.setNoSettledOrderNum(0);
        shopDAO.insert(shopDO);
        return true;
    }

    @Override
    public String queryPhoneCheckCode(String phone) {
        //
        PhoneCheckQuery query = new PhoneCheckQuery();
        query.setUserPhone(phone);
        PhoneCheckDO phoneCheckDO = phoneCheckDAO.selectByQuery(query);

        if (null != phoneCheckDO) {
            return phoneCheckDO.getCheckCode();
        }
        return null;
    }

    @Override
    public Boolean sendCheckCode(String phone) {

        String checkCode = PhoneUtil.queryRandom();
        //发短信

        //添加短信
        PhoneCheckDO checkDO = new PhoneCheckDO();
        checkDO.setCheckCode(checkCode);
        checkDO.setUserPhone(phone);
        phoneCheckDAO.insertUpdateOnDuplicate(checkDO);
        return true;
    }

    @Override
    public Boolean checkUser(String userPhone) {

        UserQuery userQuery = new UserQuery();
        userQuery.setUserPhone(userPhone);
        userQuery.setStatus(BaseStatus.NORMAL.getStatus());

        UserDO userDO = userDAO.selectByQuery(userQuery);
        if (null == userDO) {
            return true;
        }
        return false;
    }

    @Override
    public UserDTO login(String userPhone, String loginPwd, HttpServletRequest request, HttpServletResponse response) {

        //验证用户
        UserQuery userQuery = new UserQuery();
        userQuery.setUserPhone(userPhone);
        userQuery.setStatus(BaseStatus.NORMAL.getStatus());
        UserDO userDO = userDAO.selectByQuery(userQuery);
        if (null == userDO) {
            return null;
        }
        String saltKey = userDO.getLoginSalt();
        String userLoginPwd = userDO.getLoginPwd();
        String checkPwd = MD5Util.getMD5String(loginPwd + saltKey);
        if (!checkPwd.equals(userLoginPwd)) {
            return null;
        }

        //种cookie
        String sessionKey = UUIDUtil.random();
        sessionKey = EncryptUtil.encodeBase64FromAes(sessionKey, Constants.AES_SECRET_KEY);
        Cookie cookie = sessionService.getCookie(sessionKey);
        response.addCookie(cookie);
        //更新cookie
        UserDO updateDO = new UserDO();
        updateDO.setCookieKey(sessionKey);
        String lastIp = IPUtil.getLocalIp(request);
        updateDO.setLastIp(lastIp);
        Long nowTime = DateUtil.getCurrentTimeStamp();
        updateDO.setLastTime(nowTime);
        updateDO.setUpdateTime(nowTime);
        updateDO.setId(userDO.getId());
        userDAO.updateById(updateDO);
        //返回DTO

        return UserConvert.DO2DTO(userDO);
    }

    @Override
    public UserDTO updateUserInfo(Long userId, String trueName, Byte userSex) {

        UserDO userDO = new UserDO();
        userDO.setId(userId);
        userDO.setTrueName(trueName);
        userDO.setUserSex(userSex);
        userDO.setUpdateTime(DateUtil.getCurrentTimeStamp());
        userDAO.updateById(userDO);
        UserDO newUser = userDAO.selectById(userId);

        return UserConvert.DO2DTO(newUser);
    }
}

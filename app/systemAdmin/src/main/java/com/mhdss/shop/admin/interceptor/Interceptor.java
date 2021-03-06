package com.mhdss.shop.admin.interceptor;

import com.mhdss.shop.client.Exception.NotLoginException;
import com.mhdss.shop.client.dto.AuthAgent;
import com.mhdss.shop.client.dto.UserDTO;
import com.mhdss.shop.client.service.admin.SessionService;
import com.mhdss.shop.util.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@ConfigurationProperties(prefix = "shop.auth")
public class Interceptor implements InitializingBean, HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);


    private String cookieName;

    @Autowired
    private AuthAgent authAgent;

    private String[] includes;


    @Autowired
    private SessionService sessionService;

    @Override
    public void afterPropertiesSet() {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("preHandle==================== {}");

        String sessionKey = request.getHeader(cookieName);

        logger.debug("cookie key ={}", sessionKey);
        String ip = IPUtil.getLocalIp(request);
        authAgent.setIp(ip);

        UserDTO userDTO = sessionService.queryUserBySessionKey(sessionKey);

        if (null == userDTO) {
            throw new NotLoginException();
        }

        authAgent.setUserId(userDTO.getId());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


    public String[] getIncludes() {
        return includes;
    }

    public void setIncludes(String[] includes) {
        this.includes = includes;
    }

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }
}

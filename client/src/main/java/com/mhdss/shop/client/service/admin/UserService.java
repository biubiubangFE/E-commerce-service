package com.mhdss.shop.client.service.admin;

import com.mhdss.shop.client.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

    boolean register(String userPhone, String loginPwd);

    String queryPhoneCheckCode(String phone);

    Boolean sendCheckCode(String phone);

    Boolean checkUser(String userPhone);

    UserDTO login(String userPhone, String loginPwd, HttpServletRequest request, HttpServletResponse response);

    UserDTO updateUserInfo(Long userId, String trueName, Byte userSex);


}

package com.mhdss.shop.admin.controller;

import com.mhdss.shop.client.constants.ErrorCode;
import com.mhdss.shop.client.constants.ResponseData;
import com.mhdss.shop.client.dto.UserDTO;
import com.mhdss.shop.client.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/checkCode/send", method = RequestMethod.PUT)
    public ResponseData<?> sendCheckCode(@RequestParam(value = "userPhone") String userPhone) {

        Boolean tag = userService.sendCheckCode(userPhone);

        if (tag) {
            ResponseData.error(ErrorCode.SUCCESS);
        }

        return ResponseData.error(ErrorCode.HTTP_MESSAGE_READ_ERROR);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseData<?> register(@RequestParam(value = "userPhone") String userPhone,
                                    @RequestParam(value = "loginPwd") String loginPwd,
                                    @RequestParam(value = "userPhone") String checkCode) {


        String phoneCheckCode = userService.queryPhoneCheckCode(userPhone);

        if (!checkCode.equals(phoneCheckCode)) {
            return ResponseData.error(ErrorCode.CHECK_CODE_ERROR);
        }
        //验证账户

        Boolean checkUserTag = userService.checkUser(userPhone);

        if (!checkUserTag) {

            return ResponseData.error(ErrorCode.USER_PHONE_PUPLICATE);
        }

        userService.register(userPhone, loginPwd);
        return ResponseData.error(ErrorCode.SUCCESS);
    }

    @RequestMapping(value = "/user/check", method = RequestMethod.GET)
    public ResponseData<?> getCheckUser(@RequestParam(value = "userPhone") String userPhone) {

        Boolean tag = userService.checkUser(userPhone);

        if (!tag) {
            ResponseData.error(ErrorCode.USER_PHONE_PUPLICATE);
        }

        return ResponseData.success();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData<?> login(@RequestParam(value = "userPhone") String userPhone,
                                 @RequestParam(value = "loginPwd") String loginPwd,
                                 HttpServletRequest request, HttpServletResponse response) {

        UserDTO userDTO = userService.login(userPhone, loginPwd, request, response);

        if (null == userDTO) {
            return ResponseData.error(ErrorCode.USER_PHONE_OR_PWD_ERROR);
        }
        return ResponseData.success(userDTO);
    }


}

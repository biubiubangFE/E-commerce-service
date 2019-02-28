package com.mhdss.shop.admin.controller;


import com.mhdss.shop.client.constants.ErrorCode;
import com.mhdss.shop.client.constants.ResponseData;
import com.mhdss.shop.client.dto.AuthAgent;
import com.mhdss.shop.client.dto.UserDTO;
import com.mhdss.shop.client.service.admin.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private AuthAgent authAgent;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/info/update", method = RequestMethod.PUT)
    public ResponseData<?> updateUserInfo(@RequestParam(value = "trueName", required = false) String trueName,
                                          @RequestParam(value = "userSex", required = false) Byte userSex) {
        //更新用户信息

        if (StringUtils.isAllBlank(trueName) && null == userSex) {
            return ResponseData.error(ErrorCode.PARAMETER_ERROR);
        }
        Long userId = authAgent.getUserId();
        UserDTO userDTO = userService.updateUserInfo(userId, trueName, userSex);
        return ResponseData.success(userDTO);
    }

}

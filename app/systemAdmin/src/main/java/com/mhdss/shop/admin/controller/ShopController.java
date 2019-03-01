package com.mhdss.shop.admin.controller;

import com.mhdss.shop.client.constants.ResponseData;
import com.mhdss.shop.client.dto.AuthAgent;
import com.mhdss.shop.client.dto.CatsDTO;
import com.mhdss.shop.client.para.UpdateShopPara;
import com.mhdss.shop.client.service.admin.ShopService;
import com.mhdss.shop.client.service.admin.UserService;
import com.mhdss.shop.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    private AuthAgent authAgent;

    @Autowired
    private UserService userService;
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/cats/list", method = RequestMethod.PUT)
    public ResponseData<?> getShopCats() {
        //更新用户信息

        List<CatsDTO> catsDTOList = shopService.queryShopCatsList();

        return ResponseData.success(catsDTOList);
    }

    @RequestMapping(value = "/info/update", method = RequestMethod.PUT)
    public ResponseData<?> updateShopInfo(@RequestParam(value = "shopName", required = false) String shopName,
                                          @RequestParam(value = "shopAtive", required = false) Byte shopAtive,
                                          @RequestParam(value = "shopkeeper", required = false) String shopkeeper,
                                          @RequestParam(value = "telephone", required = false) String telephone,
                                          @RequestParam(value = "serviceStartTime", required = false) String serviceStartTime,
                                          @RequestParam(value = "serviceEndTime", required = false) String serviceEndTime,
                                          @RequestParam(value = "isInvoice", required = false) Byte isInvoice,
                                          @RequestParam(value = "shopImgId", required = false) Long shopImgId) {
        //完善商户信息

        UpdateShopPara shopPara = new UpdateShopPara();
        shopPara.setShopName(shopName);
        shopPara.setShopAtive(shopAtive);
        shopPara.setShopkeeper(shopkeeper);
        shopPara.setTelephone(telephone);
        shopPara.setServiceStartTime(DateUtil.getDateTimeHN(serviceStartTime));
        shopPara.setServiceEndTime(DateUtil.getDateTimeHN(serviceEndTime));
        shopPara.setIsInvoice(isInvoice);
        shopPara.setShopImgFileId(shopImgId);
        shopService.updateShopInfo(shopPara);

        return ResponseData.success();
    }


    @RequestMapping(value = "/info/get", method = RequestMethod.PUT)
    public ResponseData<?> getShopInfo() {
        //获取商户信息
        Long userId = authAgent.getUserId();
        shopService.queryShopInfo(userId);

        return ResponseData.success();
    }

    @RequestMapping(value = "/cats/get", method = RequestMethod.PUT)
    public ResponseData<?> getOneCats(@RequestParam(value = "catsId") String catsId) {
        //根据1级id,获取菜单

        List<CatsDTO> catsDTOList = shopService.queryShopCatsList();

        return ResponseData.success(catsDTOList);
    }

}

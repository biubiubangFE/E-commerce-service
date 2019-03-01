package com.mhdss.shop.admin.controller;


import com.mhdss.shop.client.constants.ResponseData;
import com.mhdss.shop.client.dto.AuthAgent;
import com.mhdss.shop.client.para.AddGoodsPara;
import com.mhdss.shop.client.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private AuthAgent authAgent;
    @Autowired
    private GoodsService goodsService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData<?> addGoods(@RequestParam(value = "goodsName") String goodsName,
                                    @RequestParam(value = "keyWord") String keyWord,
                                    @RequestParam(value = "goodsDesc") String goodsDesc,
                                    @RequestParam(value = "price") BigDecimal price,
                                    @RequestParam(value = "cost") BigDecimal cost,
                                    @RequestParam(value = "goodsCatsId") Long goodsCatsId,
                                    @RequestParam(value = "imageFileId") Long imageFileId) {

        Long userId = authAgent.getUserId();
        AddGoodsPara goodsPara = new AddGoodsPara();

        goodsPara.setUserId(userId);
        goodsPara.setCost(cost);
        goodsPara.setGoodsCatsId(goodsCatsId);
        goodsPara.setGoodsDesc(goodsDesc);
        goodsPara.setImgFileId(imageFileId);
        goodsPara.setPrice(price);
        goodsPara.setGoodsName(goodsName);
        goodsPara.setKeyWord(keyWord);
        goodsService.addGoods(goodsPara);

        return null;
    }

    @RequestMapping(value = "/detail/add", method = RequestMethod.POST)
    public ResponseData<?> addGoodsDetail(@RequestParam(value = "goodsId") String goodsId,
                                          @RequestParam(value = "goodsName") String goodsName,
                                          @RequestParam(value = "keyWord") String keyWord,
                                          @RequestParam(value = "goodsDesc") String goodsDesc,
                                          @RequestParam(value = "price") String price) {
        return null;
    }
}

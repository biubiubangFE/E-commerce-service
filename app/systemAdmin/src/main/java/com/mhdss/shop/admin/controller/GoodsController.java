package com.mhdss.shop.admin.controller;


import com.mhdss.shop.client.constants.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData<?> addGoods(@RequestParam(value = "shopCode") String shopCode,
                                    @RequestParam(value = "goodsName") String goodsName,
                                    @RequestParam(value = "keyWord") String keyWord,
                                    @RequestParam(value = "goodsDesc") String goodsDesc,
                                    @RequestParam(value = "price") String price) {
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

package com.bhzj.cloud.controller;

import com.bhzj.cloud.common.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
@RequestMapping("/commodityOrder")
public class CommodityOrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/publishCommodityOrder")
    public String publishCommodityOrder(@RequestParam("commodityId") String commodityId,
                                 @RequestParam("descMsg") String descMsg,
                                 @RequestParam("priceTicket") double priceTicket,
                                        @RequestParam("number") int number) throws UnsupportedEncodingException {
        if(descMsg!=null && descMsg.length()>0){
            descMsg = URLDecoder.decode(descMsg,"utf-8");
        }
        return RestTemplateUtil.getResult(restTemplate, "/commodityOrder/publishCommodityOrder?commodityId="+commodityId
                +"&descMsg="+descMsg+"&priceTicket="+priceTicket+"&number="+number);
    }

    @RequestMapping("/deleteCommodityOrder")
    public String deleteCommodityOrder(@RequestParam("commodityOrderId") String commodityOrderId){
        return RestTemplateUtil.getResult(restTemplate, "/commodityOrder/deleteCommodityOrder?commodityOrderId="+commodityOrderId);
    }

    @RequestMapping("/deleteCommodityOrders")
    public String deleteCommodityOrders(@RequestParam("commodityOrderIds") String commodityOrderIds){
        return RestTemplateUtil.getResult(restTemplate, "/commodityOrder/deleteCommodityOrders?commodityOrderIds="+commodityOrderIds);
    }

    @RequestMapping("/getCOListByCIdNoPhone")
    public String getCOListByCIdNoPhone(@RequestParam("commodityId") String commodityId){
        return RestTemplateUtil.getResult(restTemplate, "/commodityOrder/getCOListByCIdNoPhone?commodityId="+commodityId);
    }


    @RequestMapping("/addToTrolley")
    public String addToTrolley(@RequestParam("commodityOrderId") String commodityOrderId,
                               @RequestParam("phoneNumber") String phoneNumber){

        return RestTemplateUtil.getResult(restTemplate, "/commodityOrder/addToTrolley?commodityOrderId="+commodityOrderId+"&phoneNumber="+phoneNumber);
    }

    @RequestMapping("/getCOListByCOIdS")
    public String getCOListByCOIdS(@RequestParam("commodityOrderIds") String commodityOrderIds){
        return RestTemplateUtil.getResult(restTemplate, "/commodityOrder/getCOListByCOIdS?commodityOrderIds="+commodityOrderIds);
    }

    @RequestMapping("/getCOImgListByCOIdS")
    public String getCOImgListByCOIdS(@RequestParam("commodityOrderIds") String commodityOrderIds){
        return RestTemplateUtil.getResult(restTemplate, "/commodityOrder/getCOImgListByCOIdS?commodityOrderIds="+commodityOrderIds);
    }

    @RequestMapping("/deleteCommodityOrderFromTrolley")
    public String deleteCommodityOrderFromTrolley(@RequestParam("phoneNumber") String phoneNumber,
                                                  @RequestParam("commodityOrderId") String commodityOrderId){
        return RestTemplateUtil.getResult(restTemplate, "/commodityOrder/deleteCommodityOrderFromTrolley?phoneNumber="+phoneNumber+"&commodityOrderId="+commodityOrderId);
    }

    @RequestMapping("/getCOImgListByTrolleyPhone")
    public String getCOImgListByTrolleyPhone(@RequestParam("trolleyPhone") String trolleyPhone){
        return RestTemplateUtil.getResult(restTemplate, "/commodityOrder/getCOImgListByTrolleyPhone?trolleyPhone="+trolleyPhone);
    }

}

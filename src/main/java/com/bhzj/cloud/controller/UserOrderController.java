package com.bhzj.cloud.controller;

import com.bhzj.cloud.common.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/userOrder")
public class UserOrderController {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("/submitUserOrder")
    public String submitUserOrder(@RequestParam("phoneNumber") String phoneNumber,
                                  @RequestParam("commodityOrderIds") String commodityOrderIds,
                                  @RequestParam("commodityIdNums") String commodityIdNums,
                                  @RequestParam("totalPrice") String totalPrice){
        return RestTemplateUtil.getResult(restTemplate, "/userOrder/submitUserOrder?phoneNumber="+phoneNumber+"&commodityOrderIds="+commodityOrderIds+"&commodityIdNums="+commodityIdNums+"&totalPrice="+totalPrice);
    }


    @RequestMapping("/myUserOrder")
    public String myUserOrder(@RequestParam("phoneNumber") String phoneNumber){
        return RestTemplateUtil.getResult(restTemplate, "/userOrder/myUserOrder?phoneNumber="+phoneNumber);
    }

    @RequestMapping("/userOrderDetail")
    public String userOrderDetail(@RequestParam("userOrderId") String userOrderId){
        return RestTemplateUtil.getResult(restTemplate, "/userOrder/userOrderDetail?userOrderId="+userOrderId);
    }

    @RequestMapping("/submitReceiptMsg")
    public String submitReceiptMsg(@RequestParam("userOrderId") String userOrderId,
                                   @RequestParam("refuseCommodityOrderIds") String refuseCommodityOrderIds,
                                   @RequestParam("payPrice") double payPrice){
        return RestTemplateUtil.getResult(restTemplate, "/userOrder/submitReceiptMsg?userOrderId="+userOrderId+"&refuseCommodityOrderIds="+refuseCommodityOrderIds+"&payPrice="+payPrice);
    }

    @RequestMapping("/openedUserOrder")
    public String openedUserOrder(){
        return RestTemplateUtil.getResult(restTemplate, "/userOrder/openedUserOrder");
    }

    @RequestMapping("/updateReceiptStatus")
    public String updateReceiptStatus(@RequestParam("userOrderId") String userOrderId,
                                      @RequestParam("receiptStatus") int receiptStatus){
        return RestTemplateUtil.getResult(restTemplate, "/userOrder/updateReceiptStatus?userOrderId="+userOrderId+"&receiptStatus="+receiptStatus);
    }


    @RequestMapping("/findByReceiptStatus")
    public String findByReceiptStatus(@RequestParam("receiptStatus") int receiptStatus){
        return RestTemplateUtil.getResult(restTemplate, "/userOrder/findByReceiptStatus?receiptStatus="+receiptStatus);
    }

}

package com.bhzj.cloud.controller;

import com.bhzj.cloud.common.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/settleAccount")
public class SettleAccountController {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("settleAccount")
    public String settleAccount(
                        @RequestParam("phoneNumber") String phoneNumber,
                         @RequestParam("userOrderIds") String userOrderIds,
                         @RequestParam("settleAccountPayPrice") double settleAccountPayPrice,
                        @RequestParam("settleAccountCode") String settleAccountCode){
        return RestTemplateUtil.getResult(restTemplate, "/settleAccount/settleAccount?phoneNumber="+phoneNumber+"&userOrderIds="
                +userOrderIds+"&settleAccountPayPrice="+settleAccountPayPrice+"&settleAccountCode="+settleAccountCode);
    }



}

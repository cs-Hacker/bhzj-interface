package com.bhzj.cloud.controller;

import com.bhzj.cloud.common.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/settleAccountCode")
public class SettleAccountCodeController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/getSettleAccountCode")
    public String getSettleAccountCode(@RequestParam("shopManagerPNum") String shopManagerPNum,
                                 @RequestParam("checkDeliveryPNum") String checkDeliveryPNum){
        return RestTemplateUtil.getResult(restTemplate, "/settleAccountCode/getSettleAccountCode?shopManagerPNum="+shopManagerPNum+"&checkDeliveryPNum="+checkDeliveryPNum);
    }


}

package com.bhzj.cloud.controller;

import com.bhzj.cloud.common.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/deliveryAddressUpdate")
    public String deliveryAddressUpdate(@RequestParam("phoneNumber") String phoneNumber,
                                        @RequestParam("deliveryAddress") String deliveryAddress){
        return RestTemplateUtil.getResult(restTemplate, "/userInfo/deliveryAddressUpdate?phoneNumber="+phoneNumber+"&deliveryAddress="+deliveryAddress);
    }


}

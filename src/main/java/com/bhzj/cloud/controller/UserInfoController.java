package com.bhzj.cloud.controller;

import com.bhzj.cloud.common.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;


@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/deliveryAddressUpdate")
    public String deliveryAddressUpdate(@RequestParam("phoneNumber") String phoneNumber,
                                        @RequestParam("deliveryAddress") String deliveryAddress) throws UnsupportedEncodingException {
        deliveryAddress = deliveryAddress!=null ? new String(deliveryAddress.getBytes("ISO-8859-1"), "UTF-8") : "";
        return RestTemplateUtil.getResult(restTemplate, "/userInfo/deliveryAddressUpdate?phoneNumber="+phoneNumber+"&deliveryAddress="+deliveryAddress);
    }


    @RequestMapping("/cipherIdSubmit")
    public String cipherIdSubmit(@RequestParam("phoneNumber") String phoneNumber,
                                 @RequestParam("cipherId") String cipherId){
        return RestTemplateUtil.getResult(restTemplate, "/userInfo/cipherIdSubmit?phoneNumber="+phoneNumber+"&cipherId="+cipherId);
    }

    @RequestMapping("/initCipher")
    public String initCipher(@RequestParam("quanYiCode") String quanYiCode,
                             @RequestParam("cipherNumber") int cipherNumber){
        return RestTemplateUtil.getResult(restTemplate, "/userInfo/initCipher?quanYiCode="+quanYiCode+"&cipherNumber="+cipherNumber);
    }


}

package com.bhzj.cloud.controller;

import com.bhzj.cloud.common.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;


@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/getPhoneMsgCode")
    public String getPhoneMsgCode(@RequestParam("phoneNumber") String phoneNumber){
        return RestTemplateUtil.getResult(restTemplate, "/register/getPhoneMsgCode?phoneNumber="+phoneNumber);
    }

    @RequestMapping("/register")
    public String register(@RequestParam("phoneNumber") String phoneNumber,
                                 @RequestParam("phoneMsg") String phoneMsg,
                                 @RequestParam("password") String password,
                                 @RequestParam("deliveryAddress") String deliveryAddress,
                                @RequestParam("forget") int forget) throws UnsupportedEncodingException {
        System.out.println("deliveryAddress--=>"+deliveryAddress);
        String deliveryAddressUtf8 = "";
        if(deliveryAddress!=null){
            deliveryAddressUtf8 = new String(deliveryAddress.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("deliveryAddressUtf8--=>"+deliveryAddressUtf8);
        }
        return RestTemplateUtil.getResult(restTemplate, "/register/register?phoneNumber="+phoneNumber+"&phoneMsg="+phoneMsg+"&password="+password+"&deliveryAddress="+deliveryAddressUtf8+"&forget="+forget);
    }



}

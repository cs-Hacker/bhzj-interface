package com.bhzj.cloud.controller;

import com.bhzj.cloud.common.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/login_cellphone")
    public String loginCellphone(@RequestParam("phoneNumber") String phoneNumber,
                                 @RequestParam("password") String password,
                                 @RequestParam("code") String code){
        return RestTemplateUtil.getResult(restTemplate, "/login/login_cellphone?phoneNumber="+phoneNumber+"&password="+password+"&code="+code);
    }



}

package com.bhzj.cloud.controller;

import com.bhzj.cloud.common.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello(){
        return "hello!";
    }


    @RequestMapping("/hello2")
    public String hello2(){
        return RestTemplateUtil.getResult(restTemplate, "/test/hello");
    }

}

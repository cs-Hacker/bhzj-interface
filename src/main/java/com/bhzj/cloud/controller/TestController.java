package com.bhzj.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        String url = "https://182.43.106.149:8000/test/hello";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        if(forEntity!=null && forEntity.getBody()!=null){
            String json = forEntity.getBody().toString();
            return json;
        }
        return "空";
    }

}

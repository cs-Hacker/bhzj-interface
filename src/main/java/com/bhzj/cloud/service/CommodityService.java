package com.bhzj.cloud.service;


import com.bhzj.cloud.common.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CommodityService {

    @Autowired
    RestTemplate restTemplate;

    @Cacheable(cacheNames = "allCommodity")
    public String getAllCommodity(){
        return RestTemplateUtil.getResult(restTemplate, "/commodity/getAllCommodity");
    }

}

package com.bhzj.cloud.common.utils;

import com.bhzj.cloud.ConstantConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUtil {

    public static String getResult(RestTemplate restTemplate, String requestPath){
        String url = ConstantConfig.serviceUri +  "/test/hello";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        if(forEntity!=null && forEntity.getBody()!=null){
            String json = forEntity.getBody().toString();
            return json;
        }
        return "";
    }

}

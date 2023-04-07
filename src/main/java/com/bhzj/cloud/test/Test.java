package com.bhzj.cloud.test;

import java.net.URLDecoder;
import java.util.UUID;

public class Test {
    public static void main(String[] args) throws Exception {
        String commodityName="%E9%95%BF%E8%B1%86%E8%A7%92%E6%97%B6%E4%BB%A4%E8%94%AC%E8%8F%9C";
        System.out.println(URLDecoder.decode(commodityName));
        System.out.println(URLDecoder.decode(commodityName,"utf-8"));
    }
}

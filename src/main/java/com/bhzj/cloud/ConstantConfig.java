package com.bhzj.cloud;

import java.util.HashMap;
import java.util.Map;

public class ConstantConfig {

//    public static String serviceUri = "http://127.0.0.1:8000";
    public static String serviceUri = "http://182.43.106.149:8000";

//    public static String serviceUriImages = "http://127.0.0.1:8000/images/";
    public static String serviceUriImages = "http://182.43.106.149:8000/images/";

    public static Map<String, Integer> cTNameCTCodeMap = new HashMap();
    static {
        cTNameCTCodeMap.put("时令蔬菜", 0);
        cTNameCTCodeMap.put("新鲜水果", 1);
        cTNameCTCodeMap.put("肉蛋家禽", 2);
        cTNameCTCodeMap.put("休闲零食", 3);
        cTNameCTCodeMap.put("牛奶酸奶", 4);
    }


}

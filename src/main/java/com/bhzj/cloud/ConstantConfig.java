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
        cTNameCTCodeMap.put("免费领取", -1);

        cTNameCTCodeMap.put("时令蔬菜", 1);
        cTNameCTCodeMap.put("新鲜水果", 2);
        cTNameCTCodeMap.put("肉蛋家禽", 3);
        cTNameCTCodeMap.put("休闲零食", 4);
        cTNameCTCodeMap.put("牛奶酸奶", 5);

        cTNameCTCodeMap.put("熟食面点", 6);
        cTNameCTCodeMap.put("方便速食", 7);
        cTNameCTCodeMap.put("酒水饮料", 8);
        cTNameCTCodeMap.put("美妆个护", 9);
        cTNameCTCodeMap.put("冷藏冷冻", 10);
        cTNameCTCodeMap.put("粮油调味", 11);
        cTNameCTCodeMap.put("纸品家清", 12);
        cTNameCTCodeMap.put("日用百货", 13);
        cTNameCTCodeMap.put("母婴呵护", 14);
        cTNameCTCodeMap.put("成人用品", 15);

    }

}

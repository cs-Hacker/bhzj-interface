package com.bhzj.cloud.controller;

import com.bhzj.cloud.common.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController //Controller声明
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/getAllCommodity")
    public String getAllCommodity(){
        return RestTemplateUtil.getResult(restTemplate, "/commodity/getAllCommodity");
    }




//    @RequestMapping("addCommodity")
//    public String addCommodity(HttpServletRequest request,
//                         @RequestParam("file") MultipartFile myfile,
//                         @RequestParam("commodityId") String commodityId,
//                         @RequestParam("commodityName") String commodityName,
//                         @RequestParam("commodityTypeCode") int commodityTypeCode,
//                         @RequestParam("commodityType") String commodityType,
//                         @RequestParam("commodityPrice") String commodityPrice) throws IOException {
//        return commodityService.addCommodity(request, myfile, commodityId, commodityName, commodityTypeCode, commodityType, commodityPrice);
//    }

    @RequestMapping("deleteCommodity")
    public String deleteCommodity(
                               @RequestParam("commodityId") String commodityId){
        return RestTemplateUtil.getResult(restTemplate, "/commodity/deleteCommodity?commodityId="+commodityId);
    }


//    @RequestMapping("updateCommodity")
//    public String updateCommodity(HttpServletRequest request,
//                               @RequestParam(name="file", required=false) MultipartFile myfile,
//                               @RequestParam(name="commodityId") String commodityId,
//                               @RequestParam(name="commodityName", required=false) String commodityName,
//                               @RequestParam(name="commodityType", required=false) String commodityType,
//                               @RequestParam(name="commodityPrice", required=false) String commodityPrice,
//                               @RequestParam(name="updateImg", required=false) String updateImg) throws IOException {
//        return commodityService.updateCommodity(request, myfile, commodityId, commodityName, commodityType, commodityPrice, updateImg);
//    }

    @RequestMapping("/getCommodityListByIds")
    public String getCommodityListByIds(@RequestParam(name="commodityIds") String commodityIds){
        return RestTemplateUtil.getResult(restTemplate, "/commodity/deleteCommodity?commodityIds="+commodityIds);
    }

}

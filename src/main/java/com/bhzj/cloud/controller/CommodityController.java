package com.bhzj.cloud.controller;

import com.bhzj.cloud.ConstantConfig;
import com.bhzj.cloud.common.utils.RestTemplateUtil;
import com.bhzj.cloud.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;

@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CommodityService commodityService;

    //https://bhzj-interface-41211-8-1317629604.sh.run.tcloudbase.com/image/getImg?imageUrl=d8b2c7c0bff64ec0b2afe6455df1f977.jpeg
    @RequestMapping("/getAllCommodity")
    public String getAllCommodity(){
        return commodityService.getAllCommodity();
    }




    @RequestMapping("addCommodity")
    public String addCommodity(@RequestParam("file") MultipartFile file,
                               @RequestParam("commodityId") String commodityId,
                               @RequestParam("commodityName") String commodityName,
                               @RequestParam("commodityTypeCode") int commodityTypeCode,
                               @RequestParam("commodityType") String commodityType,
                               @RequestParam("commodityPrice") String commodityPrice,
                               @RequestParam(name="huodongIndex", required=false) Integer huodongIndex,
                               @RequestParam(name="popularizeMsg", required=false) String popularizeMsg,
                               @RequestParam(name="newUserCanGet", required=false) String newUserCanGet) {
        System.out.println("addCommodity-->" + commodityId + "---" + commodityName + "---" + commodityTypeCode + "---" + commodityType + "---" + commodityPrice);

        HttpHeaders headers = new HttpHeaders();
        //设置请求类型
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("commodityId", commodityId);
        params.add("commodityName", commodityName);
        params.add("commodityTypeCode", commodityTypeCode);
        params.add("commodityType", commodityType);
        params.add("commodityPrice", commodityPrice);
        params.add("huodongIndex", huodongIndex);
        params.add("popularizeMsg", popularizeMsg);
        params.add("newUserCanGet", newUserCanGet);
        if(file!=null){
            params.add("file", file.getResource());
        }
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(params, headers);
        String saveServiceUrl = ConstantConfig.serviceUri + "/commodity/addCommodity";//http://182.43.106.149:8000
        ResponseEntity<String> responseEntity = restTemplate.exchange(saveServiceUrl, HttpMethod.POST, requestEntity, String.class);
        return responseEntity.getBody();
    }




    @RequestMapping("addCommodityHtml")
    public String addCommodityHtml(@RequestParam("file") MultipartFile file,
                               @RequestParam("commodityId") String commodityId,
                               @RequestParam("commodityName") String commodityName,
                               @RequestParam("commodityType") String commodityType,
                               @RequestParam("commodityPrice") String commodityPrice,
                               @RequestParam(name="huodongIndex", required=false) Integer huodongIndex,
                               @RequestParam(name="popularizeMsg", required=false) String popularizeMsg,
                               @RequestParam(name="newUserCanGet", required=false) String newUserCanGet) {
        int commodityTypeCode = ConstantConfig.cTNameCTCodeMap.get(commodityType);

        return this.addCommodity(file, commodityId, commodityName, commodityTypeCode, commodityType, commodityPrice, huodongIndex, popularizeMsg, newUserCanGet);
//        return "sss";
    }


    @RequestMapping("deleteCommodity")
    public String deleteCommodity(
                               @RequestParam("commodityId") String commodityId){
        return RestTemplateUtil.getResult(restTemplate, "/commodity/deleteCommodity?commodityId="+commodityId);
    }


    @RequestMapping("updateCommodity")
    public String updateCommodity(HttpServletRequest request,
                               @RequestParam(name="file", required=false) MultipartFile file,
                               @RequestParam(name="commodityId") String commodityId,
                               @RequestParam(name="commodityName", required=false) String commodityName,
                               @RequestParam(name="commodityType", required=false) String commodityType,
                               @RequestParam(name="commodityPrice", required=false) String commodityPrice,
                               @RequestParam(name="updateImg", required=false) String updateImg,
                               @RequestParam(name="huodongIndex", required=false) Integer huodongIndex,
                               @RequestParam(name="popularizeMsg", required=false) String popularizeMsg   ) throws IOException {

        commodityName = URLDecoder.decode(commodityName,"utf-8");
        commodityType = URLDecoder.decode(commodityType,"utf-8");
        popularizeMsg = URLDecoder.decode(popularizeMsg,"utf-8");

        HttpHeaders headers = new HttpHeaders();
        //设置请求类型
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("commodityId", commodityId);
        params.add("commodityName", commodityName);
        params.add("commodityType", commodityType);
        params.add("commodityPrice", commodityPrice);
        params.add("updateImg", updateImg);
        params.add("huodongIndex", huodongIndex);
        params.add("popularizeMsg", popularizeMsg);
        if(file!=null){
            params.add("file", file.getResource());
        }
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(params, headers);
        String saveServiceUrl = ConstantConfig.serviceUri + "/commodity/updateCommodity";//http://182.43.106.149:8000
        ResponseEntity<String> responseEntity = restTemplate.exchange(saveServiceUrl, HttpMethod.POST, requestEntity, String.class);
        return responseEntity.getBody();
    }



    @RequestMapping("updateCommodityHtml")
    public String updateCommodityHtml(HttpServletRequest request,
                                  @RequestParam(name="file", required=false) MultipartFile file,
                                  @RequestParam(name="commodityId") String commodityId
//                                  @RequestParam(name="commodityName", required=false) String commodityName,
//                                  @RequestParam(name="commodityType", required=false) String commodityType,
//                                  @RequestParam(name="commodityPrice", required=false) String commodityPrice
        ) throws IOException {
//        System.out.println("file.isEmpty--->" + file.isEmpty());
//        System.out.println("updateCommodityHtml-->" + commodityId + "---" + commodityName + "---" + commodityType + "---" + commodityPrice);
        String updateImg = file.isEmpty() ? "0" : "1";
        return this.updateCommodity(request, file, commodityId, null, null, null, updateImg, null, null);
//        return "sss";
    }


    @RequestMapping("/getCommodityListByIds")
    public String getCommodityListByIds(@RequestParam(name="commodityIds") String commodityIds){
        return RestTemplateUtil.getResult(restTemplate, "/commodity/getCommodityListByIds?commodityIds="+commodityIds);
    }

    @RequestMapping("/getHuoDongCommodityIndexAll")
    public String getHuoDongCommodityIndexAll(){
        return RestTemplateUtil.getResult(restTemplate, "/commodity/getHuoDongCommodityIndexAll");
    }

    @RequestMapping("/SubmitHuoDongCommodityIndexAll")
    public String SubmitHuoDongCommodityIndexAll(@RequestParam(name="commodityIdHuoDongIndexs") String commodityIdHuoDongIndexs){
        return RestTemplateUtil.getResult(restTemplate, "/commodity/SubmitHuoDongCommodityIndexAll?commodityIdHuoDongIndexs=" + commodityIdHuoDongIndexs);
    }

}

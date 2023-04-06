package com.bhzj.cloud.controller;

import com.bhzj.cloud.ConstantConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    RestTemplate restTemplate;

    //https://bhzj-interface-41211-8-1317629604.sh.run.tcloudbase.com/image/getImg?imageUrl=d8b2c7c0bff64ec0b2afe6455df1f977.jpeg
    @RequestMapping(path = "/getImg")
    public void getImg(@RequestParam("imageUrl") String imageUrl, HttpServletResponse response) throws IOException {//

        String path = ConstantConfig.serviceUriImages + imageUrl;
        String suffix = imageUrl.substring(imageUrl.lastIndexOf(".")+1);//后缀名
        response.setContentType("image/"+suffix);// image/png
        URL uri = new URL(path);
        BufferedImage img = ImageIO.read(uri);
        ImageIO.write(img, suffix, response.getOutputStream());
//        response.setContentType("image/jpeg");//png
//        String path = "http://182.43.106.149:8000/images/d8b2c7c0bff64ec0b2afe6455df1f977.jpeg";
//        URL uri = new URL(path);
//        BufferedImage img = ImageIO.read(uri);
//        ImageIO.write(img, "jpeg", response.getOutputStream());//png
//        System.out.println("--------");
    }




//    @RequestMapping("/upload/logFiles")
//    public String receiveFile(HttpServletRequest request) {
//        //获取上传文件列表
//        MultiValueMap<String, MultipartFile> multiFileMap = ((MultipartHttpServletRequest) request).getMultiFileMap();
//        //获取文件列表第的第一个文件key
//        String first = (String) multiFileMap.keySet().iterator().next();
//        //获取文件列表中第一个文件
//        MultipartFile file = (MultipartFile) multiFileMap.getFirst(first);
//        HttpHeaders headers = new HttpHeaders();
//        //设置请求类型
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
//        params.add("vin", vin);
//        params.add("Command_session_ID", cmdSessionIdStr);
//        params.add("progress", progress);
//        params.add("sig", sig);
//        params.add("iv", iv);
//        //将获取的MultipartFile文件放入HttpEntity中
//        params.add("file", file.getResource());
//        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(params, headers);
//        ResponseEntity<String> responseEntity = restTemplate.exchange(logUpLoadUrl, HttpMethod.POST, requestEntity, String.class);
//        return responseEntity.getBody();
//    }







}

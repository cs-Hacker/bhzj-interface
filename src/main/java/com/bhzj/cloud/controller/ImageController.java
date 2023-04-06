package com.bhzj.cloud.controller;

import com.bhzj.cloud.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    //https://bhzj-interface-41211-8-1317629604.sh.run.tcloudbase.com/image/getImg?imageUrl=d8b2c7c0bff64ec0b2afe6455df1f977.jpeg
    @RequestMapping(path = "/getImg")
    public void getImg(@RequestParam("imageUrl") String imageUrl, HttpServletResponse response) throws IOException {//
        //设置返回类型
        String suffix = imageUrl.substring(imageUrl.lastIndexOf(".")+1);//后缀名
        response.setContentType("image/"+suffix);// image/png


        BufferedImage bufferedImage = imageService.getBufferedImage(imageUrl);//从缓存读(图片)


        ImageIO.write(bufferedImage, suffix, response.getOutputStream());
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

package com.bhzj.cloud.controller;

import com.bhzj.cloud.ConstantConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping("/image")
public class ImageController {

    //http://127.0.0.1:8081/image/getImg?imageUrl=d8b2c7c0bff64ec0b2afe6455df1f977.jpeg
    @RequestMapping(path = "getImg")
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

}

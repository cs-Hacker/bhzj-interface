package com.bhzj.cloud.service;



import com.bhzj.cloud.ConstantConfig;
import com.bhzj.cloud.cache.CacheType;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@Service
public class ImageService {

    @Resource
    private CacheManager cacheManager;

    @Cacheable(cacheNames = "imageCache", key = "#imageUrl")
    public BufferedImage getBufferedImage(String imageUrl) throws IOException {
        String path = ConstantConfig.serviceUriImages + imageUrl;
        URL uri = new URL(path);
        BufferedImage bufferedImage = ImageIO.read(uri);
        System.out.println("网络读取");
        return bufferedImage;
    }


    public BufferedImage watchCache(String imageUrl) {
        Cache cache = cacheManager.getCache(CacheType.IMAGE_CACHE.getCacheName());
        Cache.ValueWrapper valueWrapper = cache.get(imageUrl);
        BufferedImage bufferedImage = (BufferedImage) valueWrapper.get();
        return bufferedImage;
    }

}
package com.bhzj.cloud.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<CaffeineCache> caffeines = new ArrayList<CaffeineCache>();
        for (CacheType type : CacheType.values()) {
            CaffeineCache caffeineCache = new CaffeineCache(type.getCacheName(),
                    Caffeine.newBuilder()
                            //初始容量
                            .initialCapacity(type.getInitialCapacity())
                            //最大容量
                            .maximumSize(type.getMaximumSize())
                            //过期时间
                            .expireAfterWrite(type.getExpireTime(), type.getTimeUnit()).build());;
            caffeines.add(caffeineCache);
        }
        cacheManager.setCaches(caffeines);
        return cacheManager;
    }
}
package com.bhzj.cloud.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
public enum CacheType {

    /*
       新增缓存方法步骤:
       1. 在CacheType中新增缓存类型 (会自动创建缓存器) --> 也可以不定义新的缓存器 共用已经存在的缓存器 但要注意key的生成方式 避免key冲突
       2. 在需要缓存的方法上加入 @Cacheable注解 并给@Cacheable注解 设置步骤1中的缓存名称 及 指定缓存key生成方式

       缓存具体执行步骤:
       1.会先根据key去缓存中找缓存
       2.若找到缓存 则直接返回缓存中的数据 不会执行@Cacheable注解方法下的代码
         若没有找到缓存 则会执行方法中的代码 然后将方法的返回结果进行缓存 key为@Cacheable注解中的key指定方式生成 value为方法的返回值

       提示:
       1. 若在同一个类中调用缓存方法 请使用AOP代理 否则无法使用缓存
       2. @Cacheable: 若缓存存在，则使用缓存；不存在，则执行方法，并将结果存入缓存
          @CacheEvit: 失效缓存(等于删除缓存)
          @CachePut: 更新缓存(不管缓存存不存在,都会执行方法,然后更新缓存)
     */
	
    //将过期时间设置为30s，方便我们测试
    IMAGE_CACHE("图片缓存", "imageCache", 60, TimeUnit.SECONDS, 200, 1000);


    /**
     * 描述
     */
    private String description;

    /**
     * 缓存名称
     */
    private String cacheName;

    /**
     * 过期时间
     */
    private long expireTime;

    /**
     * 时间单位
     */
    private TimeUnit timeUnit;

    /**
     * 初始容量
     */
    private int initialCapacity;

    /**
     * 最大缓存数量
     */
    private long maximumSize;
}
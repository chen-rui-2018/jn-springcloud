package com.jn.common.util.cache;

import com.jn.common.util.cache.service.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * redis的缓存管理
 *
 * @author： fengxh
 * @date： Created on 2018/11/29 19:33
 * @version： v1.0
 * @modified By:
 */
@Component
public class RedisCacheFactory {
    private static final Logger logger = LoggerFactory.getLogger(RedisCacheFactory.class);

    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<>();

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static String KEY_PREFIX = "cache_";

    private static Integer DEFALUT_TIME= 120;

    @Value("${spring.application.name}")
    private String applicationName;


    public <V> Cache<V> getCache(String groupName, Integer expire){
        logger.debug("获取名称为:{}的RedisCache实例",groupName);
        Cache var = caches.get(groupName);
        if(var == null) {
            String keyPrefix = KEY_PREFIX+applicationName+"_"+groupName+":";
            expire = expire==null?DEFALUT_TIME:expire ;
            var = new RedisCache<V>(redisTemplate, keyPrefix,expire);
            logger.debug("初始名称为: {}，key是{},有效时间为{}秒的RedisCache实例",groupName,keyPrefix,expire);
            caches.put(groupName, var);
        }
        return var ;
    }

}

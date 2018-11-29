package com.jn.common.util.cache;

import com.jn.common.enums.CommonCacheExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.cache.service.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * redis的缓存
 *
 * @author： fengxh
 * @date： Created on 2018/11/29 19:52
 * @version： v1.0
 * @modified By:
 */
public class RedisCache<V> implements Cache<V> {

    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private RedisTemplate<String, Object> redisTemplate;

    private String keyPrefix ;

    private int expire;


    public RedisCache(RedisTemplate<String, Object> redisTemplate, String prefix,int expire){
        this.redisTemplate = redisTemplate;
        this.keyPrefix = prefix;
        this.expire = expire;
    }
    @Override
    public V get(String key) {
        try {
            if (key == null) {
                return null;
            }else{
                V value = (V)redisTemplate.opsForValue().get(keyPrefix+key);
                return value;
            }
        } catch (Throwable t) {
            logger.error("缓存加载失败",t);
            throw new JnSpringCloudException(CommonCacheExceptionEnum.CACHE_GET);
        }
    }

    @Override
    public V put(String key, V object) {
        try {
            redisTemplate.opsForValue().set(keyPrefix+key, object,expire, TimeUnit.SECONDS);
            return object;
        } catch (Throwable t) {
            logger.error("缓存保存失败",t);
            throw new JnSpringCloudException(CommonCacheExceptionEnum.CACHE_PUT);
        }
    }

    @Override
    public V remove(String key) {
        try {
            V previous = get(key);
            redisTemplate.delete(keyPrefix+key);
            return previous;
        } catch (Throwable t) {
            logger.error("缓存删除失败",t);
            throw new JnSpringCloudException(CommonCacheExceptionEnum.CACHE_DELETE);
        }
    }

    @Override
    public void clear() {
        try {
            redisTemplate.delete(redisTemplate.keys(keyPrefix+"*"));
        } catch (Throwable t) {
            logger.error("缓存删除失败",t);
            throw new JnSpringCloudException(CommonCacheExceptionEnum.CACHE_DELETE);
        }
    }

    @Override
    public int size() {
        try {
            return redisTemplate.keys(keyPrefix+"*").size();
        } catch (Throwable t) {
            logger.error("缓存加载失败",t);
            throw new JnSpringCloudException(CommonCacheExceptionEnum.CACHE_GET);
        }
    }

    @Override
    public Set<String> keys() {
        try {
            Set<String> keys = redisTemplate.keys(keyPrefix+"*");
            if (CollectionUtils.isEmpty(keys)) {
                return Collections.emptySet();
            }else{
                Set<String> newKeys = new HashSet<>();
                for(String key:keys){
                    newKeys.add(key);
                }
                return newKeys;
            }
        } catch (Throwable t) {
            logger.error("缓存加载失败",t);
            throw new JnSpringCloudException(CommonCacheExceptionEnum.CACHE_GET);
        }
    }

    @Override
    public Collection<V> values() {
        try {
            Set<String> keys = redisTemplate.keys(keyPrefix+"*");
            if (!CollectionUtils.isEmpty(keys)) {
                List<V> values = new ArrayList<>(keys.size());
                for (String key : keys) {
                    @SuppressWarnings("unchecked")
                    V value = get(key);
                    if (value != null) {
                        values.add(value);
                    }
                }
                return Collections.unmodifiableList(values);
            } else {
                return Collections.emptyList();
            }
        } catch (Throwable t) {
            logger.error("缓存加载失败",t);
            throw new JnSpringCloudException(CommonCacheExceptionEnum.CACHE_GET);

        }
    }
}

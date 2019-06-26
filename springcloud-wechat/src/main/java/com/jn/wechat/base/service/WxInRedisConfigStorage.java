package com.jn.wechat.base.service;

import com.jn.common.util.JedisFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * 基于Redis的微信配置
 *
 * @Author： cm
 * @Date： Created on 2019/1/17 16:16
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class WxInRedisConfigStorage {

    @Autowired
    private JedisFactory jedisFactory;

    private static final String ACCESS_TOKEN_KEY = "wx:access_token:";

    public static final String WX_OPENID_KEY = "wx:openid:";

    /**
     * 只能取NX或者XX，如果取NX，则只有当key不存在是才进行set，如果取XX，则只有当key已经存在时才进行set
     */
    private static String NXXX = "NX";
    /**
     * 只能取EX或者PX，代表数据过期时间的单位，EX代表秒，PX代表毫秒。
     */
    private static String EXPX = "EX";

    /**
     * 获取access_token
     * @return
     */
    public String getAccessToken() {
        Jedis jedis = jedisFactory.getJedis();
        return jedis.get(ACCESS_TOKEN_KEY);
    }

    /**
     * 缓存access_token
     * @param accessToken
     * @param expiresInSeconds
     */
    public void setAccessToken(String accessToken,int expiresInSeconds) {
        Jedis jedis = jedisFactory.getJedis();
        jedis.setex(ACCESS_TOKEN_KEY, expiresInSeconds-1000,accessToken);
    }

    /**
     * 缓存数据
     * @param key
     * @param value
     * @param expiresInSeconds
     */
    public void setCacheValue(String key,String value,int expiresInSeconds) {
        Jedis jedis = jedisFactory.getJedis();
        jedis.set(key,value,NXXX, EXPX, expiresInSeconds);
    }

    /**
     * 取缓存数据
     * @param key
     * @return
     */
    public String getCacheValue(String key) {
        Jedis jedis = jedisFactory.getJedis();
        return jedis.get(key);
    }
}

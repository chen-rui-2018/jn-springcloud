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

}

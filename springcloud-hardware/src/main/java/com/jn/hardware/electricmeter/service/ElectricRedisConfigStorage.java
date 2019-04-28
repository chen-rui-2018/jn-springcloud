package com.jn.hardware.electricmeter.service;

import com.jn.common.util.JedisFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @author： chenr
 * @date： Created on 2019/4/24 11:57
 * @version： v1.0
 * @modified By:
 */
@Component
public class ElectricRedisConfigStorage {
    @Autowired
    private JedisFactory jedisFactory;

    private static final String ACCESS_TOKEN_KEY = "electric:access_token:";

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

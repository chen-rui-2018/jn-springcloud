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
     * 控制在刷新token时,用户暂时不能去获取token(0:不可获取--1:可以获取)
     */
    private static final String ACCESS_TOKEN_KEY_CONTROLLER = "electric:access_token_controller:";

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
        jedis.setex(ACCESS_TOKEN_KEY, expiresInSeconds,accessToken);
    }
    /**
     * 获取access_token_controller
     * @return
     */
    public String getAccessTokenController() {
        Jedis jedis = jedisFactory.getJedis();
        return jedis.get(ACCESS_TOKEN_KEY_CONTROLLER);
    }

    /**
     * 缓存access_token
     * @param tokenFlag
     * @param expiresInSeconds
     */
    public void setAccessTokenController(String tokenFlag,int expiresInSeconds) {
        Jedis jedis = jedisFactory.getJedis();
        jedis.setex(ACCESS_TOKEN_KEY_CONTROLLER, expiresInSeconds,tokenFlag);
    }

}

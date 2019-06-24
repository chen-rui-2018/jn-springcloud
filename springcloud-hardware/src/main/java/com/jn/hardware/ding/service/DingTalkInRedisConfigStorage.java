package com.jn.hardware.ding.service;

import com.jn.common.util.JedisFactory;
import com.jn.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * 基于redis的钉钉配置
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 14:03
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class DingTalkInRedisConfigStorage {

    @Autowired
    private JedisFactory jedisFactory;

    @Autowired
    private DingTalkBaseService dingTalkBaseService;

    private static final String ACCESS_TOKEN_KEY = "dingTalk:access_token:";

    /**
     * 获取access_token
     * @return
     */
    public String getAccessToken() {
        Jedis jedis = jedisFactory.getJedis();
        String accessToken = jedis.get(ACCESS_TOKEN_KEY);
        if(StringUtils.isBlank(accessToken)) {
            accessToken = dingTalkBaseService.getAccessToken();
        }
        return accessToken;
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

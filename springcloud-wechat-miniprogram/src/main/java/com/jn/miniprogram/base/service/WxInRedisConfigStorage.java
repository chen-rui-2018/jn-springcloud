package com.jn.miniprogram.base.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.JedisFactory;
import com.jn.common.util.StringUtils;
import com.jn.miniprogram.base.enums.WxExceptionEnums;
import com.jn.miniprogram.base.model.WxMiniJscode2SessionResult;
import com.jn.miniprogram.base.utils.json.JacksonJsonTransformUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.io.IOException;

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

    private static final String ACCESS_TOKEN_KEY = "wxmini:access_token:";

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

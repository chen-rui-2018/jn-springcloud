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

    /**
     * 获取自定义登陆状态
     * todo 后续需考虑是否只保存session_key
     * @param customLoginStatusKey
     * @return
     */
    public WxMiniJscode2SessionResult getCustomLoginStatus(String customLoginStatusKey) {
        Jedis jedis = jedisFactory.getJedis();
        String result = jedis.get(customLoginStatusKey);
        if(StringUtils.isBlank(result)) {
            throw new JnSpringCloudException(WxExceptionEnums.GET_SESSION_KEY_OBJ_FAIL,"获取自定义登陆状态对象失败,缓存中不存在.");
        }
        WxMiniJscode2SessionResult wxMiniJscode2SessionResult;
        try {
            wxMiniJscode2SessionResult = JacksonJsonTransformUtil.jsonToObject(result,new TypeReference<WxMiniJscode2SessionResult>(){});
        } catch (IOException e) {
            throw new JnSpringCloudException(WxExceptionEnums.GET_SESSION_KEY_OBJ_FAIL);
        }

        return wxMiniJscode2SessionResult;
    }

    /**
     * 缓存自定义登陆状态
     * todo 后续加上删除缓存信息，需前端传过期的customLoginStatusKey
     * @param customLoginStatusKey
     * @param wxMiniJscode2SessionResult
     */
    public void setCustomLoginStatus(String customLoginStatusKey, WxMiniJscode2SessionResult wxMiniJscode2SessionResult) {
        Jedis jedis = jedisFactory.getJedis();
        try {
            jedis.setex(customLoginStatusKey, -1,JacksonJsonTransformUtil.objectToJson(wxMiniJscode2SessionResult));
        } catch (JsonProcessingException e) {
            throw new JnSpringCloudException(WxExceptionEnums.JSON_PROCESS_FAL);
        }
    }

}

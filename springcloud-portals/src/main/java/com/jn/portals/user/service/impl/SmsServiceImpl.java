package com.jn.portals.user.service.impl;

import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.common.util.cache.RedisCache;
import com.jn.portals.user.service.SmsService;
import com.jn.portals.user.enums.PortalsLoginExceptionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 发送短信验证码
 * @Author: yangph
 * @Date: 2018/12/3 15:44
 * @Version v1.0
 * @modified By:
 */
@Service
public class SmsServiceImpl implements SmsService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 短信验证码的redis的key
     */
    @Value(value = "${sms.key}")
    private String redisSmsKey;

    /**
     * 短信验证码的resis的过期时间
     */
    @Value(value = "${sms.expire}")
    private int expire;

    /**
     * 短信验证码的resis的前缀
     */
    @Value(value = "${sms.prefix}")
    private String prefix;

    /**
     * 保存短信验证码
     * @param phone    手机号
     * @param smsCode  短信验证码
     * @return
     */
    @Override
    public Result saveSmsCode(String phone, String smsCode) {
        Result result=new Result();
        //判断手机号和验证码是否为空
        if(StringUtils.isBlank(phone) || StringUtils.isBlank(smsCode)){
            result.setCode(PortalsLoginExceptionEnum.PHONE_SMSCODE_CANNOT_EMPTY.getCode());
            result.setResult(PortalsLoginExceptionEnum.PHONE_SMSCODE_CANNOT_EMPTY.getMessage());
            return  result;
        }
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        //手机号长度
        int phonNum=11;
        boolean matches = phone.matches(regex);
        if(phone.length()!=phonNum ||  !phone.matches(regex)){
            result.setCode(PortalsLoginExceptionEnum.PHONE_SMSCODE_CANNOT_EMPTY.getCode());
            result.setResult(PortalsLoginExceptionEnum.PHONE_SMSCODE_CANNOT_EMPTY.getMessage());
            return  result;
        }
        //把短信验证码存到redis中
        RedisCache cache=new RedisCache(redisTemplate, prefix, expire);
        cache.put(redisSmsKey+"_"+"sms"+"_"+phone, smsCode);
        return result;
    }
}

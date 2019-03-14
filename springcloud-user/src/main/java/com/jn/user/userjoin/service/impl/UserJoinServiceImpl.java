package com.jn.user.userjoin.service.impl;

import com.jn.common.channel.MessageSource;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.common.util.cache.RedisCacheFactory;
import com.jn.common.util.cache.service.Cache;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.user.userjoin.enums.UserJoinExceptionEnum;
import com.jn.user.userjoin.model.UserRegister;
import com.jn.user.userjoin.service.UserJoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 加入园区
 *
 * @author： lijun
 * @date： Created on 2019/2/28 17:57
 * @version： v1.0
 * @modified By:
 */
@Service
@EnableBinding(value = {MessageSource.class})
public class UserJoinServiceImpl implements UserJoinService {
    private static Logger logger = LoggerFactory.getLogger(UserJoinServiceImpl.class);

    @Autowired
    private RedisCacheFactory redisCacheFactory;

    @Value(value = "${message.code.expire}")
    private int expire;

    /**
     * 短信验证码组名
     */
    private static final String USER_MESSAGE_CODE="user_message_code";

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private SystemClient systemClient;

    @ServiceLog(doAction = "获取验证码")
    @Override
    public void getCode(String phone){
        if(StringUtils.isEmpty(phone)){
            throw new JnSpringCloudException(UserJoinExceptionEnum.USER_PHONE_IS_NOT_EXIST);
        }
        String messageCode = String.valueOf(new Random().nextInt(899999) + 100000);
        Cache<Object> cache = redisCacheFactory.getCache(USER_MESSAGE_CODE, expire);
        cache.put(phone,messageCode);
        SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
        smsTemplateVo.setTemplateId("1000");
        String[] m = {phone};
        smsTemplateVo.setMobiles(m);
        String[] t = {messageCode};
        smsTemplateVo.setContents(t);
        logger.info("短信发送成功：接收号码：{},验证码：{}",phone,messageCode);
        messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
    }

    @ServiceLog(doAction = "用户注册")
    @Override
    public Result addUser(UserRegister userRegister){
        //从redis中取出短信验证码
        String code = this.getSendCodeByPhone(userRegister.getPhone());
        if(!StringUtils.equals(code,userRegister.getMessageCode())){
            //验证码有误
            throw new JnSpringCloudException(UserJoinExceptionEnum.MESSAGE_CODE_IS_WRONG);
        }
            User user = new User();
            user.setPhone(userRegister.getPhone());
            user.setAccount(userRegister.getPhone());
            user.setPassword(userRegister.getPassword());
           return systemClient.addSysUser(user);

    }

    @ServiceLog(doAction = "修改密码")
    @Override
    public Result updateUser(UserRegister userRegister){
        //从redis中取出短信验证码
        String code = this.getSendCodeByPhone(userRegister.getPhone());
        if(!StringUtils.equals(code,userRegister.getMessageCode())){
            //验证码有误
            throw new JnSpringCloudException(UserJoinExceptionEnum.MESSAGE_CODE_IS_WRONG);
        }
        User user = new User();
        user.setAccount(userRegister.getPhone());
        user.setPassword(userRegister.getPassword());
        return systemClient.updateSysUser(user);
    }

    @Override
    public String getSendCodeByPhone(String phone){
        Cache<Object> cache = redisCacheFactory.getCache(USER_MESSAGE_CODE, expire);
        return (String)cache.get(phone);
    }

}

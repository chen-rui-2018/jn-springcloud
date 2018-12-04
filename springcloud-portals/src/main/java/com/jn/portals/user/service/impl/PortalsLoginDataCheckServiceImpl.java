package com.jn.portals.user.service.impl;

import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.common.util.cache.RedisCache;
import com.jn.portals.enums.PortalsExceptionEnum;
import com.jn.portals.model.PortalUserLogin;
import com.jn.portals.user.service.PortalsLoginDataCheckService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 登录信息数据校验
 * @Author: yangph
 * @Date: 2018/11/29 14:41
 * @Version v1.0
 * @modified By:
 */
@Service
public class PortalsLoginDataCheckServiceImpl implements PortalsLoginDataCheckService {
    /**
     * 日志组件
     */
    private static Logger logger= LoggerFactory.getLogger(PortalsLoginDataCheckServiceImpl.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 滑动验证redis的key
     */
    @Value(value = "${side_validation.key}")
    private String redisSildeKey;

    /**
     * 滑动验证redis的前缀
     */
    @Value(value = "${side_validation.prefix}")
    private String sidePrefix;
    /**
     * 滑动验证redis的过期时间
     */
    @Value(value = "${side_validation.expire}")
    private int sideExpire;

    /**
     * 短信验证码的redis的key
     */
    @Value(value = "${sms.key}")
    private String redisSmsKey;

    /**
     * 短信验证码的resis的过期时间
     */
    @Value(value = "${sms.expire}")
    private int smsExpire;

    /**
     * 短信验证码的resis的前缀
     */
    @Value(value = "${sms.prefix}")
    private String smsPrefix;

    /**
     * 登录模式：账号密码登录、手机号验证码登录、微信登录、app登录
     */
    @Value(value = "${LOGIN_TYPE_WEB}")
    private String loginTypeWeb;
    @Value(value = "${LOGIN_TYPE_SMS}")
    private String loginTypeSms;
    @Value(value = "${LOGIN_TYPE_WECHAT}")
    private String loginTypeWechat;
    @Value(value = "${LOGIN_TYPE_APP}")
    private String loginTypeApp;

    /**
     * 平台登录信息数据校验
     * @param portalUserLogin 登录用户信息
     * @return
     */
    @ServiceLog(doAction = "登录信息数据校验")
    @Override
    public Result loginDataCheck(PortalUserLogin portalUserLogin) {
        Result result=new Result();
        //校验账号
        if(StringUtils.isBlank(portalUserLogin.getAccount())){
            logger.info("----登录账号不能为空----");
            result.setCode(PortalsExceptionEnum.ACCOUNT_CANNOT_EMPTY.getCode());
            result.setResult(PortalsExceptionEnum.ACCOUNT_CANNOT_EMPTY.getMessage());
            return  result;
        }
        //校验登录模式
        String logintype=portalUserLogin.getLogintype();
        if(StringUtils.isBlank(logintype)){
            logger.info("----登录模式不能为空----");
            result.setCode(PortalsExceptionEnum.LOGIN_TYPE_CANNOT_EMPTY.getCode());
            result.setResult(PortalsExceptionEnum.LOGIN_TYPE_CANNOT_EMPTY.getMessage());
            return  result;
        }
        if( !(loginTypeWeb.equals(logintype) || loginTypeSms.equals(logintype)||
                loginTypeWechat.equals(logintype)|| loginTypeApp.equals(logintype))){
            logger.info("----当前登录模式[{}]系统不支持----",logintype);
            result.setCode(PortalsExceptionEnum.LOGIN_TYPE_CANNOT_SUPPORT.getCode());
            result.setResult(PortalsExceptionEnum.LOGIN_TYPE_CANNOT_SUPPORT.getMessage());
            return  result;
        }
        //账号密码登录，校验滑动验证key是否为空
        if(loginTypeWeb.equals(logintype) && StringUtils.isBlank(portalUserLogin.getVerifyKey())){
            logger.info("----滑动验证参数错误----");
            result.setCode(PortalsExceptionEnum.SIDE_VALTIDATION_PARAM_ERROR.getCode());
            result.setResult(PortalsExceptionEnum.SIDE_VALTIDATION_PARAM_ERROR.getMessage());
            return  result;
        }
        //账号密码登录，校验是否通过滑动验证
        if(loginTypeWeb.equals(logintype)){
            RedisCache cache=new RedisCache(redisTemplate, sidePrefix, sideExpire);
            String xValue = (String)cache.get(redisSildeKey + "_" + "xCoord" + "_" + portalUserLogin.getVerifyKey());

            //滑动验证通过标识
            String okFlag="ok";
            //滑动验证结果不是"OK",表示滑动验证不通过或滑动验证已失效
            if(StringUtils.isBlank(xValue) || !okFlag.equals(xValue)){
                logger.info("----滑动验证不通过或验证结果已失效----");
                result.setCode(PortalsExceptionEnum.SIDE_VALIDATION_MSG.getCode());
                result.setResult(PortalsExceptionEnum.SIDE_VALIDATION_MSG.getMessage());
                return result;
            }
        }
        //手机号短信验证码登录，校验验证码是否正确
        if(loginTypeSms.equals(logintype)){
            RedisCache cache=new RedisCache(redisTemplate, smsPrefix, smsExpire);
            String smsCode=(String)cache.get(redisSmsKey+"_"+"sms"+"_"+portalUserLogin.getAccount());
            //前端传过来的短信验证码和redis中的验证码不一致
            if(StringUtils.isBlank(smsCode) || !smsCode.equals(portalUserLogin.getPassword())){
                logger.info("---验证码不正确或已失效---");
                result.setCode(PortalsExceptionEnum.SMS_CODE_ISERROR.getCode());
                result.setResult(PortalsExceptionEnum.SMS_CODE_ISERROR.getMessage());
                return result;
            }
        }
        return result;
    }
}

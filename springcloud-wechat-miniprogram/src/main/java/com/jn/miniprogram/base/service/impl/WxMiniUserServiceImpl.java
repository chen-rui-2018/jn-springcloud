package com.jn.miniprogram.base.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.encryption.AESUtil;
import com.jn.miniprogram.base.enums.WxExceptionEnums;
import com.jn.miniprogram.base.model.WxMiniGetTokenParam;
import com.jn.miniprogram.base.model.WxMiniJscode2SessionResult;
import com.jn.miniprogram.base.model.WxMiniRegisterUserGetTokenParam;
import com.jn.miniprogram.base.model.WxMiniUserInfo;
import com.jn.miniprogram.base.service.WxMiniHttpClientService;
import com.jn.miniprogram.base.service.WxMiniUserService;
import com.jn.miniprogram.base.utils.crypto.WxMiniCryptUtil;
import com.jn.miniprogram.base.utils.json.JacksonJsonTransformUtil;
import com.jn.miniprogram.config.WxMiniProperties;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.UserNoPasswordLogin;
import com.jn.user.api.MiniProgramRegisterClient;
import com.jn.user.model.RegisterInfoParam;
import com.jn.user.model.WeChatRequestParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 小程序用户信息相关接口实现
 *
 * @Author： cm
 * @Date： Created on 2019/3/12 20:00
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class WxMiniUserServiceImpl implements WxMiniUserService {

    private static Logger logger = LoggerFactory.getLogger(WxMiniUserServiceImpl.class);

    @Autowired
    private WxMiniProperties wxMiniProperties;
    @Autowired
    private WxMiniHttpClientService wxMiniHttpClientService;
    @Autowired
    private SystemClient systemClient;
    @Autowired
    private MiniProgramRegisterClient miniProgramRegisterClient;

    @Override
    @ServiceLog(doAction = "用code换取openid、session_key.")
    public WxMiniJscode2SessionResult getSessionInfo(String code) {
        String result = wxMiniHttpClientService.get(String.format(JSCODE_TO_SESSION_URL,wxMiniProperties.getAppId(), wxMiniProperties.getSecret(),code));
        //openid、session_key关键信息不不打印在日志中
        logger.info("\n小程序登陆凭证校验入参code：【{}】",code);
        WxMiniJscode2SessionResult wxMiniJscode2SessionResult;
        try {
            wxMiniJscode2SessionResult = JacksonJsonTransformUtil.jsonToObject(result,new TypeReference<WxMiniJscode2SessionResult>(){});
        } catch (IOException e) {
            throw new JnSpringCloudException(WxExceptionEnums.WX_LOGIN_CODE_CHECK_FAIL);
        }
        return wxMiniJscode2SessionResult;
    }

    @Override
    @ServiceLog(doAction = "小程序用户信息校验")
    public boolean checkUserInfo(String sessionKey, String rawData, String signature) {
        String generatedSignature = DigestUtils.sha1Hex(rawData + sessionKey);
        return generatedSignature.equals(signature);
    }

    @Override
    @ServiceLog(doAction = "获取小程序加密的用户信息")
    public WxMiniUserInfo getUserInfo(String sessionKey, String encryptedData, String ivStr) {
        try {
            return JacksonJsonTransformUtil.jsonToObject(WxMiniCryptUtil.decrypt(sessionKey, encryptedData, ivStr),new TypeReference<WxMiniUserInfo>(){});
        } catch (IOException e) {
            throw new JnSpringCloudException(WxExceptionEnums.GET_ENCRYPT_USER_INFO_FAIL);
        }
    }

    @Override
    @ServiceLog(doAction = "校验用户登陆凭证、保存微信用户信息、返回token")
    public Result<String> checkCodeAndGetToken(WxMiniGetTokenParam wxMiniGetTokenParam) {
        //用code换取openid、session_key
        WxMiniJscode2SessionResult wxMiniJscode2SessionResult = this.getSessionInfo(wxMiniGetTokenParam.getCode());
        //调用User服务保存小程序用户信息，并拿到账号信息
        WeChatRequestParam weChatRequestParam = new WeChatRequestParam();
        BeanUtils.copyProperties(wxMiniGetTokenParam,weChatRequestParam);
        weChatRequestParam.setOpenId(wxMiniJscode2SessionResult.getOpenid());
        weChatRequestParam.setUnionId(wxMiniJscode2SessionResult.getUinionid());
        Result<String> result = miniProgramRegisterClient.isBindingAccountByOpenId(weChatRequestParam);
        logger.info("\n调用User服务保存小程序用户信息，并拿到账号信息的入参：【{}】,出参：【{}】",weChatRequestParam,result);
        //判断小程序用户信息是否保存成功，是否有账号信息,有账号则调用免密登陆接口拿到token
        if(null != result && GlobalConstants.SUCCESS_CODE.equals(result.getCode())) {
            if(StringUtils.isNotBlank(result.getData())) {
                result.setData(getTokenByAccount(result.getData()));
            }else {
                //未注册是正常现象,不用抛异常
                result.setCode(WxExceptionEnums.WX_NO_BING_USER.getCode());
                result.setResult(WxExceptionEnums.WX_NO_BING_USER.getMessage());
            }
        }
        return result;
    }

    @ServiceLog(doAction = "注册绑定微信用户信息、返回token")
    @Override
    public Result<String> registerUserAndGetToken(WxMiniRegisterUserGetTokenParam wxMiniRegisterUserGetTokenParam) {
        //用code换取openid、session_key
        WxMiniJscode2SessionResult wxMiniJscode2SessionResult = this.getSessionInfo(wxMiniRegisterUserGetTokenParam.getCode());
        //调用User服务注册绑定小程序用户信息
        RegisterInfoParam registerInfoParam = new RegisterInfoParam();
        registerInfoParam.setCode(wxMiniRegisterUserGetTokenParam.getPhoneCode());
        registerInfoParam.setPhone(wxMiniRegisterUserGetTokenParam.getPhone());
        registerInfoParam.setOpenId(wxMiniJscode2SessionResult.getOpenid());
        Result<String> result = miniProgramRegisterClient.registerAndBinding(registerInfoParam);
        logger.info("\n调用User服务注册绑定小程序用户信息入参：【{}】,出参：【{}】",registerInfoParam,result);
        if(null != result && GlobalConstants.SUCCESS_CODE.equals(result.getCode())) {
            result.setData(getTokenByAccount(result.getData()));
        }else {
            //设置注册失败的code，描述使用接口返回的描述信息
            throw new JnSpringCloudException(WxExceptionEnums.WX_USER_REGISTER_FAIL,result.getResult());
        }
        return result;
    }

    /**
     * 根据账号调用免密登陆接口获取token
     * @param account
     * @return
     */
    public String getTokenByAccount(String account) {
        if(StringUtils.isBlank(account)) {
            return "";
        }
        UserNoPasswordLogin userNoPasswordLogin = new UserNoPasswordLogin();
        userNoPasswordLogin.setAccount(AESUtil.encrypt(account, AESUtil.DEFAULT_KEY));
        Result<String> result = systemClient.noPasswordLogin(userNoPasswordLogin);
        logger.info("\n调用免密登陆接口获取TOKEN的入参：【{}】,出参：【{}】",account,result);
        if(null != result && GlobalConstants.SUCCESS_CODE.equals(result.getCode())) {
            return result.getData();
        }
        throw new JnSpringCloudException(WxExceptionEnums.WX_GET_TOKEN_FAIL,result.getResult());
    }

}

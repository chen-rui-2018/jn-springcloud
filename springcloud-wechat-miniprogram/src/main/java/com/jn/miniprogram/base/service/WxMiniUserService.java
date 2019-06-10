package com.jn.miniprogram.base.service;

import com.jn.common.model.Result;
import com.jn.miniprogram.base.model.WxMiniGetTokenParam;
import com.jn.miniprogram.base.model.WxMiniJscode2SessionResult;
import com.jn.miniprogram.base.model.WxMiniRegisterUserGetTokenParam;
import com.jn.miniprogram.base.model.WxMiniUserInfo;

/**
 * 小程序用户信息相关接口
 *
 * @Author： cm
 * @Date： Created on 2019/3/12 19:46
 * @Version： v1.0
 * @Modified By:
 */
public interface WxMiniUserService {

    String JSCODE_TO_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    /**
     * 根据临时登录凭证 code 获取openid、session_key等信息
     * @param code
     * @return
     */
    WxMiniJscode2SessionResult getSessionInfo(String code);

    /**
     * 用户信息校验
     * @param sessionKey
     * @param rawData
     * @param signature
     * @return
     */
    boolean checkUserInfo(String sessionKey, String rawData, String signature);

    /**
     * 解密用户敏感数据
     * @param sessionKey        会话密钥
     * @param encryptedData     消息密文
     * @param ivStr             加密算法的初始向量
     * @return 小程序加密用户信息
     */
    WxMiniUserInfo getUserInfo(String sessionKey, String encryptedData, String ivStr);

    /**
     * 获取token
     * @param wxMiniGetTokenParam
     * @return
     */
    Result<String> checkCodeAndGetToken(WxMiniGetTokenParam wxMiniGetTokenParam);

    /**
     * 注册绑定微信用户信息并获取token
     * @param wxMiniRegisterUserGetTokenParam
     * @return
     */
    Result<String> registerUserAndGetToken(WxMiniRegisterUserGetTokenParam wxMiniRegisterUserGetTokenParam);
}

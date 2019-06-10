package com.jn.miniprogram.base.service;

import com.jn.miniprogram.base.model.WxMiniUserInfo;

/**
 * 微信小程序基础API的Service.
 *
 * @Author： cm
 * @Date： Created on 2019/3/9 16:23
 * @Version： v1.0
 * @Modified By:
 */
public interface WxMiniService {
    /**
     * 获取access_token.
     */
    String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    /**
     * 验证消息的确来自微信服务器.
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    boolean checkSignature(String timestamp, String nonce, String signature);

    /**
     * 强制刷新获取AccessToken
     * @return
     */
    String getAccessToken();

}

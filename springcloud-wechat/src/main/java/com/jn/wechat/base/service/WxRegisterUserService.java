package com.jn.wechat.base.service;

import com.jn.wechat.model.WxUserRegisterBindingParam;

/**
 * 微信服务号用户绑定注册接口类
 *
 * @Author： cm
 * @Date： Created on 2019/6/25 21:35
 * @Version： v1.0
 * @Modified By:
 */
public interface WxRegisterUserService {

    /**
     * 微信服务号绑定手机号码,注册用户信息
     * @param wxUserRegisterBindingParam
     */
    void registerBinding(WxUserRegisterBindingParam wxUserRegisterBindingParam);
}

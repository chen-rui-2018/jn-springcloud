package com.jn.miniprogram.register.service;

import com.jn.user.model.RegisterInfoParam;

/**
 * @Author: yangph
 * @Date: 2019/3/11 20:15
 * @Version v1.0
 * @modified By:
 */
public interface MiniprogramRegisterService {

    /**
     * 判断OpenId是否已绑定
     * @param openId 微信用户openId
     * @return 0:未绑定  1：已绑定
     */
    int isBindingOpenId(String openId);

    /**
     * 注册并绑定
     * @param registerInfoParam  注册绑定入参
     * @return
     */
    int registerAndBinding(RegisterInfoParam registerInfoParam);

}

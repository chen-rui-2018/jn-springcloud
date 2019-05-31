package com.jn.miniprogram.register.service;

import com.jn.user.model.RegisterInfoParam;
import com.jn.user.model.WeChatRequestParam;

/**
 * @Author: yangph
 * @Date: 2019/5/25 14:25
 * @Version v1.0
 * @modified By:
 */
public interface MiniProgramRegistersService {
    /**
     * 判断OpenId是否已绑定账号
     * @param weChatRequestParam 微信用户信息
     * @return 已绑定，返回手机号   未绑定，返回空
     */
    String isBindingAccountByOpenId(WeChatRequestParam weChatRequestParam);

    /**
     * 注册并绑定
     * @param registerInfoParam  注册绑定入参
     * @return
     */
    String registerAndBinding(RegisterInfoParam registerInfoParam);

    /**
     * 根据账号获取openId
     * @param account
     * @return
     */
    String getOpenIdByAccount(String account);
}

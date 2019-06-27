package com.jn.miniprogram.register.service;

import com.jn.miniprogram.register.enums.RegisterTypeEnum;
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
     * @param registerTypeEnum  微信注册枚举
     * @return 已绑定，返回手机号   未绑定，返回空
     */
    String isBindingAccountByOpenId(WeChatRequestParam weChatRequestParam, RegisterTypeEnum registerTypeEnum);

    /**
     * 用户关注/取消关注服务号
     * @param weChatRequestParam
     */
    int concernOrCancelWeChat(WeChatRequestParam weChatRequestParam);



    /**
     * 根据OpenId判断OpenId是否已绑定
     * @param openId
     * @return
     */
    String openIdIsBindingAccount(String openId,RegisterTypeEnum registerTypeEnum);

    /**
     * 注册并绑定
     * @param registerInfoParam  注册绑定入参
     * @param registerTypeEnum 微信注册枚举
     * @return
     */
    String registerAndBinding(RegisterInfoParam registerInfoParam, RegisterTypeEnum registerTypeEnum);

    /**
     * 根据账号获取openId
     * @param account
     * @param registerTypeEnum 微信注册枚举
     * @return
     */
    String getOpenIdByAccount(String account,RegisterTypeEnum registerTypeEnum);
}

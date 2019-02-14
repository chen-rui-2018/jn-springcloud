package com.jn.wechat.base.service;


import com.jn.wechat.base.model.result.WxUser;

/**
 * 微信用户管理相关操作接口.
 *
 * @Author： cm
 * @Date： Created on 2019/1/8 15:28
 * @Version： v1.0
 * @Modified By:
 */
public interface WxUserService {

    String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";

    /**
     * 获取用户基本信息（语言为默认的zh_CN 简体）
     * @param openid 用户openid
     * @return
     */
    WxUser userInfo(String openid);

    /**
     * 获取用户基本信息
     * @param openid 用户openid
     * @param lang 语言，zh_CN 简体(默认)，zh_TW 繁体，en 英语
     * @return
     */
    WxUser userInfo(String openid, String lang);

}

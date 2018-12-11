package com.jn.user.userinfo.service;


import com.jn.user.model.UserExtension;

/**
 * 获取用户信息
 * @Author: yangph
 * @Date: 2018/12/10 11:31
 * @Version v1.0
 * @modified By:
 */
public interface UserInfoService {
    /**
     * 根据账号获取用户扩展信息
     * @param account 用户账号
     * @return
     */
    UserExtension getUserInfo(String account);
}

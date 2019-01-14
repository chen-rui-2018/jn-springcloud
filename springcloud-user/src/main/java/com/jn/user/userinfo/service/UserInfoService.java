package com.jn.user.userinfo.service;


import com.jn.user.model.UserExtension;

import java.util.List;

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
    UserExtension getUserExtension(String account);

    /**
     * 批量获取用户的扩展信息
     * @param accountList  用户账号集合
     * @return
     */
    List<UserExtension> getMoreUserExtension(List<String> accountList);
}

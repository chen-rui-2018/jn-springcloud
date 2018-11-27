package com.jn.authorization.service;

import com.jn.authorization.model.PlatformUser;

/**
 * 平台登录
 * @Author: yangph
 * @Date: 2018/11/21 16:29
 * @Version v1.0
 * @modified By:
 */
public interface PlatformLoginService {
    /**
     * 根据用户id获取用户的个人拓展信息和企业拓展信息
     * @param userId 用户id
     * @return
     */
    PlatformUser platformLoginPost(String userId);
}

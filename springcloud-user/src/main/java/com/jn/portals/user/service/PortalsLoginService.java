package com.jn.portals.user.service;


import com.jn.portals.user.model.PortalsUser;

import java.util.List;

/**
 * 平台登录
 * @Author: yangph
 * @Date: 2018/11/28 9:39
 * @Version v1.0
 * @modified By:
 */
public interface PortalsLoginService {
    /**
     * 根据用户账号获取用户的个人拓展信息和企业拓展信息
     * @param account 用户账号
     * @return
     */
    List<PortalsUser> getUserOutreachInfo(String account);
}

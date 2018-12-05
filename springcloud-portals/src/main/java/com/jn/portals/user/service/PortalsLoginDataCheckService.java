package com.jn.portals.user.service;

import com.jn.common.model.Result;
import com.jn.portals.model.PortalUserLogin;


/**
 * 登录信息数据校验
 * @Author: yangph
 * @Date: 2018/11/29 14:38
 * @Version v1.0
 * @modified By:
 */
public interface PortalsLoginDataCheckService {
    /**
     * 平台登录信息数据校验
     * @param portalUserLogin 登录用户信息
     * @return
     */
    Result loginDataCheck(PortalUserLogin portalUserLogin);
}

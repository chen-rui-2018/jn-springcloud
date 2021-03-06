package com.jn.authorization;

import com.jn.system.model.UserLogin;

/**
 * 用户登录
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By: shenph
 */
public interface LoginService {

    /**
     * 登录
     * @param user 用户对象
     * @param isNoPasswordLogin 免密登录
     */
    void login(UserLogin user,Boolean isNoPasswordLogin);

    void logoutJSON();
}

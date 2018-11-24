package com.jn.authorization;

import com.jn.system.user.model.UserLogin;


/**
 * 用户登录
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By: shenph
 */
public interface LoginService {

    void login(UserLogin user);

    void logoutJSON();
}

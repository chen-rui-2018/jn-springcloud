package com.jn.user.userjoin.service;

import com.jn.system.model.User;
import com.jn.user.userjoin.model.UserRegister;

/**
 * 加入园区
 *
 * @author： lijun
 * @date： Created on 2019/2/28 17:55
 * @version： v1.0
 * @modified By:
 */

public interface UserJoinService {

    /**
     * 获取短信验证码
     * @param phone 手机号
     */
    void getCode(String phone);

    /**
     * 用户注册
     * @param userRegister
     */
    void addUser(UserRegister userRegister);

    /**
     * 修改密码
     * @param userRegister
     */
    void updateUser(UserRegister userRegister);
}

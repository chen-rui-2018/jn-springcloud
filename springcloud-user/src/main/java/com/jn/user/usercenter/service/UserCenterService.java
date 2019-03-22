package com.jn.user.usercenter.service;

import com.jn.user.model.UserExtensionInfo;
import com.jn.user.usercenter.model.ModifyPassword;

/**
 * @author： chenr
 * @date： Created on 2019/3/5 19:45
 * @version： v1.0
 * @modified By:
 */
public interface  UserCenterService {
    /**
     * 修改密码
     * @param user
     */
    void  modifyUserPassword(ModifyPassword user);

    /**
     * 根据账号获取用户信息
     * @param account
     * @return
     */
    UserExtensionInfo getUserExtension(String account);
}

package com.jn.user.usercenter.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.encryption.EncryptUtil;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.system.model.UserLogin;
import com.jn.user.enums.UserExtensionExceptionEnum;
import com.jn.user.model.UserExtensionInfo;
import com.jn.user.usercenter.model.ModifyPassword;
import com.jn.user.usercenter.service.UserCenterService;
import com.jn.user.userinfo.service.UserInfoService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author： chenr
 * @date： Created on 2019/3/5 19:47
 * @version： v1.0
 * @modified By:
 */
@Service
public class UserCenterServiceImpl implements UserCenterService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(UserCenterServiceImpl.class);
    @Autowired
    private SystemClient systemClient;
    @Autowired
    private UserInfoService userInfoService;
    @ServiceLog(doAction = "修改用户密码信息")
    @Override
    public void modifyUserPassword(ModifyPassword modifyPassword) {
        UserLogin userLogin = new UserLogin();
        userLogin.setAccount(modifyPassword.getAccount());
        userLogin.setPassword(modifyPassword.getOldPassword());
        Result result = systemClient.login(userLogin);
        if(!GlobalConstants.SUCCESS_CODE.equals(result.getCode())){
            logger.warn("[用户密码修改]，用户旧密码{}密码错误：oldPassword{},密码错误,请重新输入正确的密码");
           throw new JnSpringCloudException(UserExtensionExceptionEnum.USER_PASSWORD_IS_ERROR);
        }
        User user = new User();
        user.setAccount(modifyPassword.getAccount());
        Result<User> resultUser = systemClient.getUser(user);

        String passwordSha256= EncryptUtil.encryptSha256(modifyPassword.getOldPassword());
       if(!resultUser.getData().getPassword().equals(passwordSha256)){
           logger.warn("[用户密码修改]，用户旧密码{}密码错误：oldPassword{},密码错误,请重新输入正确的密码");
           throw new JnSpringCloudException(UserExtensionExceptionEnum.USER_PASSWORD_IS_ERROR);
       }
        user.setPassword(modifyPassword.getNewPassword());
        systemClient.updateSysUser(user);
    }

    @ServiceLog(doAction = "根据账号获取用户信息")
    @Override
    public UserExtensionInfo getUserExtension(String account) {
        UserExtensionInfo userInfo =   userInfoService.getUserExtension(account);
        return userInfo;
    }

}

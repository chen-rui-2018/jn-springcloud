package com.jn.user.usercenter.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.encryption.AESUtil;
import com.jn.common.util.encryption.EncryptUtil;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.user.enums.UserExtensionExceptionEnum;
import com.jn.user.model.UserExtensionInfo;
import com.jn.user.usercenter.model.ModifyPassword;
import com.jn.user.usercenter.service.UserCenterService;
import com.jn.user.userinfo.service.UserInfoService;
import com.jn.user.userjoin.enums.UserJoinExceptionEnum;
import com.jn.user.utils.PasswordRuleUtil;
import com.jn.user.vo.PasswordValidVO;
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

    @Override
    @ServiceLog(doAction = "修改用户密码信息")
    public void modifyUserPassword(ModifyPassword modifyPassword) {
        String oldPassword = AESUtil.decrypt(modifyPassword.getOldPassword(), AESUtil.DEFAULT_KEY);
        String newPassword = AESUtil.decrypt(modifyPassword.getNewPassword(), AESUtil.DEFAULT_KEY);
        String account = AESUtil.decrypt(modifyPassword.getAccount(), AESUtil.DEFAULT_KEY);

        User user = new User();
        user.setAccount(account);
        Result<User> resultUser = systemClient.getUser(user);
        String passwordSha256 = EncryptUtil.encryptSha256(oldPassword);
        if (!resultUser.getData().getPassword().equals(passwordSha256)) {
            logger.warn("[用户密码修改]，用户旧密码{}密码错误：oldPassword{},密码错误,请重新输入正确的密码");
            throw new JnSpringCloudException(UserExtensionExceptionEnum.USER_PASSWORD_IS_ERROR);
        }

        PasswordValidVO valid = PasswordRuleUtil.isValid(newPassword);
        if (!valid.isValid()) {
            logger.warn("[用户密码修改] {}", valid.getMessage());
            throw new JnSpringCloudException(UserJoinExceptionEnum.PASSWORD_INVALID, UserJoinExceptionEnum.PASSWORD_INVALID.getMessage() + "（" + valid.getMessage() + "）");
        }
        user.setPassword(newPassword);
        systemClient.updateSysUser(user);
    }

    @ServiceLog(doAction = "根据账号获取用户信息")
    @Override
    public UserExtensionInfo getUserExtension(String account) {
        UserExtensionInfo userInfo =   userInfoService.getUserExtension(account);
        return userInfo;
    }

}

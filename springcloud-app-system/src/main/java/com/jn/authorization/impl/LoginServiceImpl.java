package com.jn.authorization.impl;

import com.jn.authorization.LoginService;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.encryption.EncryptUtil;
import com.jn.system.config.MyUsernamePasswordToken;
import com.jn.system.enums.ShiroExceptionEnum;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.UserLogin;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * 用户登录
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By: shenph
 */
@Service
public class LoginServiceImpl implements LoginService {

    @ServiceLog(doAction = "登录")
    @Override
    public void login(UserLogin user,Boolean isNoPasswordLogin) {
        try {
            Subject userShiro = SecurityUtils.getSubject();
            MyUsernamePasswordToken token = new MyUsernamePasswordToken(user.getAccount(), EncryptUtil.encryptSha256(user.getPassword()).toCharArray());
            token.setNoPassword(isNoPasswordLogin);
            userShiro.login(token);
        } catch (UnknownAccountException e) {
            throw new JnSpringCloudException(ShiroExceptionEnum.UNKNOWN_ACCOUNT);
        } catch (DisabledAccountException e) {
            throw new JnSpringCloudException(ShiroExceptionEnum.UNKNOWN_EFFECTIVE);
        } catch (IncorrectCredentialsException e) {
            throw new JnSpringCloudException(ShiroExceptionEnum.UNKNOWN_PASSWORD);
        }
    }

    @ServiceLog(doAction = "登出")
    @Override
    public void logoutJSON() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

}



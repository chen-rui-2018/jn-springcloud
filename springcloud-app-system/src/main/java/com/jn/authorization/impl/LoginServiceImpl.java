package com.jn.authorization.impl;


import com.jn.authorization.LoginService;
import com.jn.system.model.UserLogin;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * 登录
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Override
    public void login(UserLogin user) {
        Subject userShiro = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), DigestUtils.md5Hex(user.getPassword()).toCharArray());
        userShiro.login(token);
    }

    @Override
    public void logoutJSON() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

}



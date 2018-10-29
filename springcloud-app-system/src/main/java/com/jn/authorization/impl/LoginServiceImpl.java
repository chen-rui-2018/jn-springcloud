package com.jn.authorization.impl;


import com.jn.authorization.LoginService;
import com.jn.system.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {


    @Override
    public void login(User user) {
        Subject userShiro = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), DigestUtils.md5Hex(user.getPassword()).toCharArray());
        userShiro.login(token);
    }

    @Override
    public void logoutJSON() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

}



package com.wangsong.system.service.impl;


import com.wangsong.system.service.LoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {


    @Override
    public void loginPost(String username, String password) {
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, DigestUtils.md5Hex(password).toCharArray());
        user.login(token);
    }

    @Override
    public void logoutJSON() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

}



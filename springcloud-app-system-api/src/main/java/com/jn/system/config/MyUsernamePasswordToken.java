package com.jn.system.config;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * MyUsernamePasswordToken
 *
 * @author Co
 */
public class MyUsernamePasswordToken extends UsernamePasswordToken {

    public MyUsernamePasswordToken(String username, String password) {
        setUsername(username);
        setPassword(password == null ? null : password.toCharArray());
    }

    public MyUsernamePasswordToken(String username, char[] password) {
        super(username, (char[])password, false, (String)null);
    }

    /**
     * 是否需要密码
     */
    private boolean isNoPassword;

    public boolean isNoPassword() {
        return isNoPassword;
    }

    public void setNoPassword(boolean noPassword) {
        isNoPassword = noPassword;
    }


}

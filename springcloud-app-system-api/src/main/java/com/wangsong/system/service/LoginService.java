package com.wangsong.system.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    void loginPost(String username, String password);

    void logoutJSON();
}

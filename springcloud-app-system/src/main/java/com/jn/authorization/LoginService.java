package com.jn.authorization;

import com.jn.system.model.UserLogin;

public interface LoginService {

    void login(UserLogin user);

    void logoutJSON();
}

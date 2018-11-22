package com.jn.authorization;

import com.jn.system.user.model.UserLogin;

public interface LoginService {

    void login(UserLogin user);

    void logoutJSON();
}

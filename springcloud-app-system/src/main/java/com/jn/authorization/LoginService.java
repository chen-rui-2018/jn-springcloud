package com.jn.authorization;

import com.jn.system.model.User;

public interface LoginService {

    void login(User user);

    void logoutJSON();
}

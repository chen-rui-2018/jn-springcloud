package com.jn.system.service;

import com.jn.common.model.GetEasyUIData;
import com.jn.system.model.User;
import com.jn.system.model.UserAddModel;
import com.jn.system.model.UserPage;
import com.jn.system.model.UserRole;
import com.jn.system.vo.UserVO;

public interface UserService {

    User selectByPrimaryKey();

    void insertUser(UserAddModel muser);

    void updateUser(UserAddModel muser);

    void deleteUser(String[] id);

    void updatePassword(UserAddModel u);

    GetEasyUIData findTByPage(UserPage user);

    UserVO selectByPrimaryKey(String id);

    User findTByT(User user);

    void deleteByT(UserRole[] u);


}

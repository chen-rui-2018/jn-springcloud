package com.jn.system.service;

import com.jn.common.model.GetEasyUIData;
import com.jn.system.model.User;
import com.jn.system.model.UserAdd;
import com.jn.system.model.UserPage;
import com.jn.system.model.UserRole;
import com.jn.system.vo.UserVO;
/**
 * 用户
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public interface UserService {

    User selectByPrimaryKey();

    void insertUser(UserAdd muser);

    void updateUser(UserAdd muser);

    void deleteUser(String[] id);

    void updatePassword(UserAdd u);

    GetEasyUIData findTByPage(UserPage user);

    UserVO selectByPrimaryKey(String id);

    User findTByT(User user);

    void deleteByT(UserRole[] u);


}

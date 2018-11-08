package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.system.model.User;
import com.jn.system.model.UserAdd;
import com.jn.system.model.UserPage;
import com.jn.system.model.UserRole;
import com.jn.system.vo.UserVO;

import java.util.List;

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

    PaginationData findTByPage(UserPage user);

    UserVO selectByPrimaryKey(String id);

    List<User> findTByT(User user);

    void deleteByT(UserRole[] u);


}

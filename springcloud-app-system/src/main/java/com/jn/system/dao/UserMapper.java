package com.jn.system.dao;

import com.jn.system.model.User;
import com.jn.system.model.UserAdd;
import com.jn.system.model.UserPage;
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
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    List<User> findTByPage(UserPage user);

    int findTCountByT(UserPage user);

    void deleteBy(String[] id);

    User findTByT(User user);

    User findTByTOne(User user);

    void updateNoPasswordByPrimaryKey(UserAdd user);

    UserVO selectVOByPrimaryKey(String id);


}
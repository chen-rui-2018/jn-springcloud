package com.jn.system.dao;

import com.jn.system.model.User;
import com.jn.system.model.UserRole;

import java.util.List;
/**
 * 用户角色
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public interface UserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    UserRole selectByPrimaryKey(String id);

    List<UserRole> selectAll();

    int updateByPrimaryKey(User record);

    void deleteByT(UserRole[] u);

    List<UserRole> findTByT(UserRole userRole);
}
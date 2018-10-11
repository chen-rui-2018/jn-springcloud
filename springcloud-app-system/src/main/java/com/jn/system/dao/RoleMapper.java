package com.jn.system.dao;

import com.jn.system.model.Role;
import com.jn.system.model.RolePage;
import com.jn.system.vo.RoleVO;

import java.util.List;
/**
 * 角色
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public interface RoleMapper {

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    Role selectByPrimaryKey(String id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    List<Role> findTByPage(RolePage role);

    int findTCountByT(RolePage role);

    void deleteBy(String[] id);

    RoleVO selectRoleVOByPrimaryKey(String id);

}
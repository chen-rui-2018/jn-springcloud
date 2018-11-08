package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.system.model.*;
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
public interface RoleService {

    void insertRole(RoleAdd role);

    void updateRole(RoleAdd role);

    void deleteRole(String[] id);

    PaginationData findTByPage(RolePage role);

    RoleVO selectByPrimaryKey(String id);

    List<Role> selectAll();

    void deleteByT(RoleResources[] r);

    List<Resources> findResourcesByT(Resources resources);

}

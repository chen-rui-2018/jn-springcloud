package com.jn.system.service;

import com.jn.common.model.GetEasyUIData;
import com.jn.system.model.*;
import com.jn.system.vo.RoleVO;

import java.util.List;

public interface RoleService {

    void insertRole(RoleAddModel role);

    void updateRole(RoleAddModel role);

    void deleteRole(String[] id);

    GetEasyUIData findTByPage(RolePage role);

    RoleVO selectByPrimaryKey(String id);

    List<Role> selectAll();

    void deleteByT(RoleResources[] r);

    List<Resources> findResourcesByT(Resources resources);

}

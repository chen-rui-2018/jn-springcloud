package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.GetEasyUIData;
import com.jn.system.dao.RoleMapper;
import com.jn.system.dao.RoleResourcesMapper;
import com.jn.system.model.*;
import com.jn.system.service.RoleService;
import com.jn.system.service.UserService;
import com.jn.system.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * 角色
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleResourcesMapper roleResourcesMapper;


    @Override
    @Transactional
    public void insertRole(RoleAdd role) {
        String[] resourcesId = role.getResourcesId();
        role.setId(UUID.randomUUID().toString());
        roleMapper.insert(role);
        if (resourcesId == null) {
            return;
        }
        for (int i = 0; i < resourcesId.length; i++) {
            roleResourcesMapper.insert(new RoleResources(UUID.randomUUID().toString()
                    , resourcesId[i], role.getId()));
        }
    }

    @Override
    @Transactional
    public void updateRole(RoleAdd role) {
        String[] resourcesId = role.getResourcesId();
        roleResourcesMapper.deleteByT(new RoleResources[]{new RoleResources(null, null, role.getId())});
        roleMapper.updateByPrimaryKey(role);
        if (resourcesId == null) {
            return;
        }
        for (int i = 0; i < resourcesId.length; i++) {
            roleResourcesMapper.insert(new RoleResources(UUID.randomUUID().toString(), resourcesId[i], role.getId()));
        }
    }

    @Override
    @Transactional
    public void deleteRole(String[] id) {
        RoleResources[] r = new RoleResources[id.length];
        UserRole[] u = new UserRole[id.length];
        for (int i = 0; i < id.length; i++) {
            r[i] = new RoleResources(null, null, id[i]);
            u[i] = new UserRole(null, null, id[i]);
        }

        userService.deleteByT(u);
        roleResourcesMapper.deleteByT(r);
        roleMapper.deleteBy(id);
    }

    @Override
    public GetEasyUIData findTByPage(RolePage role) {
        Page<Object> objects = PageHelper.startPage(role.getPage(), role.getRows());
        return new GetEasyUIData(roleMapper.findTByPage(role)
                , objects.getTotal());
    }

    @Override
    public RoleVO selectByPrimaryKey(String id) {
        RoleVO role = roleMapper.selectRoleVOByPrimaryKey(id);
        role.setRoleResourcesList(roleResourcesMapper.findTByT(new RoleResources(null, null, id)));
        return role;
    }

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public void deleteByT(RoleResources[] r) {
        roleResourcesMapper.deleteByT(r);
    }

    @Override
    public List<Resources> findResourcesByT(Resources resources) {
        return roleResourcesMapper.findResourcesByT(resources);
    }
}

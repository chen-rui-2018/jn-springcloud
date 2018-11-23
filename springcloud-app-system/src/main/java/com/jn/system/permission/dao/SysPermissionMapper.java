package com.jn.system.permission.dao;

import com.jn.system.permission.model.SysPermission;
import com.jn.system.permission.model.SysPermissionPage;

import java.util.List;

/**
 * 权限持久层
 * @author： shaobao
 * @date： Created on 2018/11/9 9:19
 * @version： v1.0
 * @modified By:
 **/
public interface SysPermissionMapper {
    /**
     * 根据权限id修改权限信息
     * @param sysPermission
     */
    void updatePermission(SysPermission sysPermission);

    /**
     * 分页条件查询
     * @param sysPermissionPage
     * @return
     */
    List<SysPermission> findByPage(SysPermissionPage sysPermissionPage);

    /**
     * 批量删除权限
     * @param ids
     */
    void deletePermissionBranch(String[] ids);
}

package com.jn.system.permission.dao;

import com.jn.system.permission.model.SysPermission;
import com.jn.system.permission.model.SysPermissionPage;

import java.util.List;
import java.util.Map;

/**
 * 权限持久层
 *
 * @author： shaobao
 * @date： Created on 2018/11/9 9:19
 * @version： v1.0
 * @modified By:
 **/
public interface SysPermissionMapper {

    /**
     * 分页条件查询
     *
     * @param sysPermissionPage
     * @return
     */
    List<SysPermission> findByPage(SysPermissionPage sysPermissionPage);

    /**
     * 批量删除权限
     *
     * @param map
     */
    void deletePermissionBranch(Map<String, Object> map);
}

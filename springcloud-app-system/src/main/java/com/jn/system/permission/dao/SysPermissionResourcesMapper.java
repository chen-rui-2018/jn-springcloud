package com.jn.system.permission.dao;

import com.jn.system.menu.model.SysResources;
import com.jn.system.permission.entity.TbSysPermissionResources;
import com.jn.system.permission.model.SysPermissionResourcePage;

import java.util.List;

/**
 * 权限功能Mapper
 *
 * @author： shaobao
 * @date： Created on 2018/11/9 11:32
 * @version： v1.0
 * @modified By:
 **/
public interface SysPermissionResourcesMapper {
    /**
     * 根据权限id批量删除对应信息
     *
     * @param ids
     */
    void deletePermissionBranch(String[] ids);

    /**
     * 根据权限id获取权限已经具有的功能信息
     *
     * @param id
     * @return
     */
    List<SysResources> findResourcesOfPermission(String id);

    /**
     * 逻辑删除原有权限页面功能数据
     *
     * @param permissionId
     */
    void deleteByPermissionId(String permissionId);

    /**
     * 添加新权限页面功能数据
     *
     * @param tbSysPermissionResourcesList
     */
    void addResourceToPermission(List<TbSysPermissionResources> tbSysPermissionResourcesList);

    /**
     * 条件分页获取未拥有的功能信息
     *
     * @param sysPermissionResourcePage
     * @return
     */
    List<SysResources> findResourceByPermissionPage(SysPermissionResourcePage sysPermissionResourcePage);
}

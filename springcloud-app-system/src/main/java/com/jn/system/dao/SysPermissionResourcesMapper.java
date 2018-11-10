package com.jn.system.dao;

import com.jn.system.entity.TbSysPermissionResources;
import com.jn.system.model.SysResources;

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
     * 根据权限id获取权限已经具有的页面功能之外的页面功能
     *
     * @param permissionId
     * @return
     */
    List<SysResources> findOtherResources(String permissionId);

    /**
     * 逻辑删除原有权限页面功能数据
     *
     * @param permissionId
     */
    void deleteByPermissionId(String permissionId);

    /**
     * 添加新权限页面功能数据
     * @param tbSysPermissionResourcesList
     */
    void addResourceToPermission(List<TbSysPermissionResources> tbSysPermissionResourcesList);
}

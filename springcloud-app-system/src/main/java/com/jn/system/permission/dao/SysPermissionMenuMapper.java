package com.jn.system.permission.dao;

import com.jn.system.permission.entity.TbSysPermissionMenu;

import java.util.List;

/**
 * 权限菜单Mapper
 *
 * @author： shaobao
 * @date： Created on 2018/11/9 11:27
 * @version： v1.0
 * @modified By:
 **/
public interface SysPermissionMenuMapper {

    /**
     * 根据权限id批量删除对应信息
     *
     * @param ids
     */
    void deletePermissionBranch(String[] ids);

    /**
     * 根据权限id获取权限具有的菜单信息
     *
     * @param id
     * @return
     */
    List<String> findMenuOfPermission(String id);

    /**
     * 逻辑删除原权限菜单数据
     *
     * @param permissionId
     */
    void deleteByPermissionId(String permissionId);

    /**
     * 添加新权限菜单数据
     *
     * @param tbSysPermissionMenuList
     */
    void addMenuToPermission(List<TbSysPermissionMenu> tbSysPermissionMenuList);

    /**
     * 删除菜单及子菜单对应的权限信息
     *
     * @param menuIds
     */
    void deleteBy(List<String> menuIds);
}

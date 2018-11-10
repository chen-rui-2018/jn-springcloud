package com.jn.system.dao;

import com.jn.system.entity.TbSysPermissionMenu;
import com.jn.system.model.SysMenu;

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
    List<SysMenu> findMenuOfPermission(String id);

    /**
     * 根据权限id获取权限已经具有的菜单之外的其他菜单
     *
     * @param id
     * @return
     */
    List<SysMenu> findOtherMenu(String id);

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
}

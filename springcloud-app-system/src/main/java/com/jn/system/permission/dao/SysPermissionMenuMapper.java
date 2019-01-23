package com.jn.system.permission.dao;

import com.jn.system.permission.entity.TbSysPermissionMenu;

import java.util.List;
import java.util.Map;

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
     * @param map
     */
    void deletePermissionBranch(Map<String, Object> map);

    /**
     * 根据权限id获取权限具有的菜单信息
     *
     * @param id
     * @return
     */
    List<String> findMenuOfPermission(String id);

    /**
     * 添加新权限菜单数据
     *
     * @param tbSysPermissionMenuList
     */
    void addMenuToPermission(List<TbSysPermissionMenu> tbSysPermissionMenuList);

    /**
     * 删除菜单及子菜单对应的权限信息
     *
     * @param map
     */
    void deleteBy(Map<String, Object> map);
}

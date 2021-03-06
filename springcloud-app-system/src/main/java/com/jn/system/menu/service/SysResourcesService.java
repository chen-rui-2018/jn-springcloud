package com.jn.system.menu.service;

import com.jn.system.menu.entity.TbSysResources;
import com.jn.system.menu.model.SysResourceCheckName;
import com.jn.system.menu.model.SysResources;
import com.jn.system.model.MenuResources;
import com.jn.system.model.User;

import java.util.List;
import java.util.Set;


/**
 * 功能service
 *
 * @author： yuanyy
 * @date： Created on 2018/11/5 11:46
 * @version： v1.0
 * @modified By:
 */
public interface SysResourcesService {

    /**
     * 新增功能
     *
     * @param tbSysResources
     */
    void insertResources(TbSysResources tbSysResources);

    /**
     * 更新功能信息
     *
     * @param sysResources
     * @param user
     */
    void updateResourcesById(SysResources sysResources, User user);

    /**
     * 逻辑删除功能信息
     *
     * @param resourcesIds
     * @param user         获取当前用户
     */
    void deleteResourcesById(String[] resourcesIds, User user);

    /**
     * 根据id查询功能详情
     *
     * @param id
     * @return
     */
    SysResources selectSysResourcesById(String id);

    /**
     * 根据id查找用户拥有权限列表
     *
     * @param id 用户ID
     * @return
     */
    Set<String> findPermissionsUrlById(String id);

    /**
     * 根据id查找用户拥有功能权限列表
     *
     * @param id 用户ID
     * @return
     */
    List<MenuResources> getMenuResourcesUrlById(String id);

    /**
     * 校验页面功能名称是否存在
     *
     * @param sysResourceCheckName
     * @return
     */
    String checkResourceName(SysResourceCheckName sysResourceCheckName);

    /**
     * 根据菜单id获取菜单所有页面功能
     *
     * @param menuId
     * @return
     */
    List<TbSysResources> findResourcesByMenuId(String menuId);
}

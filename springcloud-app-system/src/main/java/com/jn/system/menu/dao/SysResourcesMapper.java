package com.jn.system.menu.dao;


import com.jn.system.menu.model.SysResources;
import com.jn.system.menu.model.SysResourcesPage;
import com.jn.system.menu.vo.SysResourcesVO;
import com.jn.system.model.MenuResources;
import com.jn.system.permission.model.SysResourcesOfPermission;

import java.util.List;
import java.util.Set;

/**
 * 功能mapper
 *
 * @author： yuanyy
 * @date： Created on 2018/11/05 15:31
 * @version： v1.0
 * @modified By:
 */
public interface SysResourcesMapper {


    /**
     * 根据ids批量删除
     *
     * @param id
     */
    void deleteByIds(String[] id);

    /**
     * 根据主键查询功能菜单列表
     *
     * @param sysResourcesPage
     * @return
     */
    List<SysResourcesVO> findMenuResourcesByPage(SysResourcesPage sysResourcesPage);

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
     * 根据id查询功能详情
     *
     * @param id
     * @return
     */
    SysResources findResourceById(String id);

    /**
     * 根据功能id获取菜单名称
     *
     * @param resourcesId
     * @return
     */
    List<String> findMenuNameByResourcesId(String resourcesId);

    /**
     * 删除菜单及子菜单的功能信息
     *
     * @param menuIds
     */
    void deleteBy(List<String> menuIds);

    /**
     * 根据id获取功能信息
     * @param id
     * @return
     */
    SysResources getResourcesById(String id);

    /**
     * 根据菜单id获取页面功能信息
     * @param id
     * @return
     */
    List<SysResourcesOfPermission> getResourcesByMenuId(String id);
}
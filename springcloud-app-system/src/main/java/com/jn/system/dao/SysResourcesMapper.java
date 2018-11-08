package com.jn.system.dao;


import com.jn.system.model.MenuResources;
import com.jn.system.model.SysResources;
import com.jn.system.model.SysResourcesPage;
import com.jn.system.vo.SysResourcesVO;

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
     * @param id
     */
    void deleteByIds(String[] id);

    /**
     * 根据主键查询功能菜单列表
     * @param sysResourcesPage
     * @return
     */
    List<SysResourcesVO> findMenuResourcesByPage(SysResourcesPage sysResourcesPage);

    /**
     * 根据id查找用户拥有权限列表
     * @param id 用户ID
     * @return
     */
    Set<String> findPermissionsUrlById(String id);

    /**
     * 根据id查找用户拥有功能权限列表
     * @param id 用户ID
     * @return
     */
    List<MenuResources> getMenuResourcesUrlById(String id);
}
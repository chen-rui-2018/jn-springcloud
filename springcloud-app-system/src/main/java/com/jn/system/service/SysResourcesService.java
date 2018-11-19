package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.model.MenuResources;
import com.jn.system.model.SysResources;
import com.jn.system.model.SysResourcesPage;

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
     * @param sysResources
     */
    void insertResources(SysResources sysResources);

    /**
     * 更新功能信息
     *
     * @param sysResources
     */
    void updateResourcesById(SysResources sysResources);

    /**
     * 批量删除功能（逻辑删除）
     *
     * @param resourcesIds
     * @return
     */
    void deleteResourcesById(String[] resourcesIds);

    /**
     * 分页查询功能功能列表信息
     *
     * @param sysResourcesPage
     * @return
     */
    PaginationData selectResourcesListBySearchKey(SysResourcesPage sysResourcesPage);

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
     * @param resourceName
     * @return
     */
    Result checkResourceName(String resourceName);
}

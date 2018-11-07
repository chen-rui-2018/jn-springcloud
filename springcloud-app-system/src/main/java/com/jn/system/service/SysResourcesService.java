package com.jn.system.service;

import com.jn.common.model.GetEasyUIData;
import com.jn.system.model.SysResources;
import com.jn.system.model.SysResourcesPage;


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
     * @param sysResources
     */
    void insertResources(SysResources sysResources);

    /**
     * 更新功能信息
     * @param sysResources
     */
    void updateResourcesById(SysResources sysResources);

    /**
     * 批量删除功能（逻辑删除）
     * @param resourcesIds
     * @return
     */
    void deleteResourcesById(String[] resourcesIds);

    /**
     * 分页查询功能功能列表信息
     * @param sysResourcesPage
     * @return
     */
    GetEasyUIData selectResourcesListBySearchKey(SysResourcesPage sysResourcesPage);

    /**
     * 根据id查询功能详情
     * @param id
     * @return
     */
    SysResources selectSysResourcesById(String id);

}

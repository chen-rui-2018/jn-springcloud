package com.jn.system.permission.dao;

import com.jn.system.permission.entity.TbSysPermissionResources;

import java.util.List;
import java.util.Map;

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
     * @param map
     */
    void deletePermissionBranch(Map<String,Object> map);

    /**
     * 根据权限id获取权限已经具有的功能信息
     *
     * @param id
     * @return
     */
    List<String> findResourcesOfPermission(String id);

    /**
     * 添加新权限页面功能数据
     *
     * @param tbSysPermissionResourcesList
     */
    void addResourceToPermission(List<TbSysPermissionResources> tbSysPermissionResourcesList);

    /**
     * 根据功能id批量删除表信息
     * @param map
     */
    void deleteByResourcesIds(Map<String,Object> map);
}

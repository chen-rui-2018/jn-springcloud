package com.jn.system.dao;

import com.jn.system.entity.TbSysPermissionFiles;
import com.jn.system.model.SysFileGroup;

import java.util.List;

/**
 * 权限文件组Mapper
 *
 * @author： shaobao
 * @date： Created on 2018/11/9 11:22
 * @version： v1.0
 * @modified By:
 **/
public interface SysPermissionFilesMapper {
    /**
     * 根据权限id批量删除对应信息
     *
     * @param ids
     */
    void deletePermissionBranch(String[] ids);

    /**
     * 根据权限id获取除权限已经具有的文件组信息
     *
     * @param id
     * @return
     */
    List<SysFileGroup> findFileGroupOfPermission(String id);

    /**
     * 根据权限id获取除权限已经具有的文件组之外的文件组信息
     *
     * @param id
     * @return
     */
    List<SysFileGroup> findOtherFileGroups(String id);

    /**
     * 根据权限id逻辑删除原有权限对应文件组
     * @param permissionId
     */
    void deleteByPermissionId(String permissionId);

    /**
     * 为权限添加新的文件组
     * @param list
     */
    void addFileGroupToPermission(List<TbSysPermissionFiles> list);
}

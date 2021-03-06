package com.jn.system.permission.dao;

import com.jn.system.file.model.SysFileGroup;
import com.jn.system.permission.entity.TbSysPermissionFiles;
import com.jn.system.permission.model.SysPermissionFileGroupPage;

import java.util.List;
import java.util.Map;

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
     * @param map
     */
    void deletePermissionBranch(Map<String, Object> map);

    /**
     * 根据权限id获取除权限已经具有的文件组信息
     *
     * @param id
     * @return
     */
    List<SysFileGroup> findFileGroupOfPermission(String id);

    /**
     * 为权限添加新的文件组
     *
     * @param list
     */
    void addFileGroupToPermission(List<TbSysPermissionFiles> list);

    /**
     * 条件分页获取未拥有的文件组信息
     *
     * @param sysPermissionFileGroupPage
     * @return
     */
    List<SysFileGroup> findFileGroupByPermissionPage(SysPermissionFileGroupPage sysPermissionFileGroupPage);

    /**
     * 根据文件组id批量权限文件组信息
     *
     * @param map
     */
    void deleteByFileGroupIds(Map<String, Object> map);
}

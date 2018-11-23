package com.jn.system.file.service;

import com.jn.common.model.PaginationData;
import com.jn.system.file.entity.TbSysFileGroup;
import com.jn.system.file.model.SysFileGroup;
import com.jn.system.file.model.SysFileGroupFileAdd;
import com.jn.system.file.model.SysFileGroupPage;
import com.jn.system.model.User;

import java.util.List;

/**
 * 文件组service
 *
 * @author： yuanyy
 * @date： Created on 2018/11/5 23:14
 * @version： v1.0
 * @modified By:
 */
public interface SysFileGroupService {
    /**
     * 新增文件组
     *
     * @param sysFileGroup
     */
    void insertSysFileGroup(SysFileGroup sysFileGroup,User user);

    /**
     * 根据id更新文件组
     *
     * @param sysFileGroup
     */
    void updateSysFileGroupById(SysFileGroup sysFileGroup);

    /**
     * 批量删除文件组（逻辑删除）
     *
     * @param ids
     */
    void deleteSysFileGroupByIds(String[] ids);

    /**
     * 根据id查询文件组
     *
     * @param id
     * @return
     */
    SysFileGroup selectSysFileGroupByIds(String id);

    /**
     * 根据关键字分页查询文件组列表
     *
     * @param sysFileGroupPage
     * @return
     */
    PaginationData selectSysFileGroupListBySearchKey(SysFileGroupPage sysFileGroupPage);


    /**
     * 文件组添加文件
     *
     * @param sysFileGroupFileAdd
     */
    void sysFileGroupFileAdd(SysFileGroupFileAdd sysFileGroupFileAdd,User user);

    /**
     * 根据用户获取文件组
     *
     * @param userId 用户ID
     * @return
     */
    List<TbSysFileGroup> getUserFileGroupById(String userId);

    /**
     * 获取用户是否拥有该文件的下载权限
     *
     * @param userId
     * @param fileUrl
     * @return
     */
    Boolean getUserFilePermission(String userId, String fileUrl);

    /**
     * 校验文件组是否存在
     *
     * @param fileGroupName
     * @return
     */
    String checkFileGroupName(String fileGroupName);
}

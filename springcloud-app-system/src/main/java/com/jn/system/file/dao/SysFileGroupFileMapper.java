package com.jn.system.file.dao;


import com.jn.system.file.entity.TbSysFileGroup;
import com.jn.system.file.model.SysFilePage;
import com.jn.system.file.vo.SysFileVO;

import java.util.List;
import java.util.Map;

/**
 * 文件文件组关联mapper
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
public interface SysFileGroupFileMapper {
    /**
     * 批量删除
     *
     * @param id
     * @return
     */
    int deleteByIds(String[] id);

    /**
     * 根据fileId批量删除
     *
     * @param id
     * @return
     */
    int deleteByFileIds(String[] id);

    /**
     * 根据fileId批量删除
     *
     * @param map
     * @return
     */
    int deleteByFileGroupIds(Map<String, Object> map);

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
     * @param userId  用户ID
     * @param fileUrl 文件路径
     * @return
     */
    List<String> getUserFilePermission(String userId, String fileUrl);

    /**
     * 根据文件id获取对应文件组名称
     *
     * @param fileId
     * @return
     */
    List<String> findFileGroupNameByFileId(String fileId);

    /**
     * 按文件组查询文件信息
     *
     * @param sysFilePage
     * @return
     */
    List<SysFileVO> findFileByFileGroupName(SysFilePage sysFilePage);
}
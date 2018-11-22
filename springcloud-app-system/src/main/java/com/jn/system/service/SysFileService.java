package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.model.SysFile;
import com.jn.system.model.SysFileAddFileGroup;
import com.jn.system.model.SysFilePage;
import com.jn.system.model.User;

/**
 * 文件service
 *
 * @author： yuanyy
 * @date： Created on 2018/11/5 23:14
 * @version： v1.0
 * @modified By:
 */
public interface SysFileService {
    /**
     * 新增文件
     *
     * @param sysFile
     */
    void insertSysFile(SysFile sysFile, User user);

    /**
     * 根据id更新文件
     *
     * @param sysFile
     */
    void updateSysFileById(SysFile sysFile);

    /**
     * 批量删除文件（逻辑删除）
     *
     * @param ids
     */
    void deleteSysFileByIds(String[] ids);

    /**
     * 根据id查询文件
     *
     * @param id
     * @return
     */
    SysFile selectSysFileByIds(String id);

    /**
     * 根据关键字分页查询文件列表
     *
     * @param sysFilePage
     * @return
     */
    PaginationData selectSysFileListBySearchKey(SysFilePage sysFilePage);

    /**
     * 文件添加文件组
     *
     * @param sysFileAddFileGroup
     */
    void sysFileAddFileGroup(SysFileAddFileGroup sysFileAddFileGroup , User user);

    /**
     * 校验文件名称
     *
     * @param fileName
     * @return
     */
    String checkFileName(String fileName);
}

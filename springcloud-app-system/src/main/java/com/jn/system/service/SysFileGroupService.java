package com.jn.system.service;

import com.jn.common.model.GetEasyUIData;
import com.jn.system.model.SysFileGroup;
import com.jn.system.model.SysFileGroupFileAdd;
import com.jn.system.model.SysFileGroupPage;
import com.jn.system.vo.SysFileGroupVO;

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
     * @param sysFileGroup
     */
    void insertSysFileGroup(SysFileGroup sysFileGroup);

    /**
     * 根据id更新文件组
     * @param sysFileGroup
     */
    void updateSysFileGroupById(SysFileGroup sysFileGroup);

    /**
     * 批量删除文件组（逻辑删除）
     * @param ids
     */
    void deleteSysFileGroupByIds(String[] ids);

    /**
     * 根据id查询文件组
     * @param id
     * @return
     */
    SysFileGroup selectSysFileGroupByIds(String id);

    /**
     * 根据关键字分页查询文件组列表
     * @param sysFileGroupPage
     * @return
     */
    GetEasyUIData selectSysFileGroupListBySearchKey(SysFileGroupPage sysFileGroupPage);


    /**
     * 文件组添加文件
     * @param sysFileGroupFileAdd
     */
    void sysFileGroupFileAdd(SysFileGroupFileAdd sysFileGroupFileAdd);
}

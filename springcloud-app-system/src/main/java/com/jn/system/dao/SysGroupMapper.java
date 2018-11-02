package com.jn.system.dao;

import com.jn.system.vo.TbSysGroup;

import java.util.List;

/**
 * 用户组dao
 *
 * @author： shaobao
 * @date： Created on 2018/10/30 15:30
 * @version： v1.0
 * @modified By:
 */
public interface SysGroupMapper  {

    /**
     * 查询所有用户组信息
     * @return
     */
    List<TbSysGroup> findSysGroupAll();

    /**
     * 根据用户id对应用户组
     * @param id
     * @return
     */
    List<TbSysGroup> findSysGroupByUserId(String id);

    /**
     * 增加用户组
     * @param sysGroup
     */
    void addSysGroup(TbSysGroup sysGroup);

    /**
     * 逻辑删除用户组
     * @param groupId
     */
    void deleSysGroup(String groupId);

    /**
     * 更新用户组信息
     * @param sysGroup
     */
    void updateSysGroup(TbSysGroup sysGroup);

    /**
     * 根据用户组id获取用户组信息
     * @param id 用户组id
     * @return
     */
    TbSysGroup findSysGroupById(String id);
}

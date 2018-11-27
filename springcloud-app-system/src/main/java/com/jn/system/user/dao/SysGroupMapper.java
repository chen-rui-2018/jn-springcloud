package com.jn.system.user.dao;

import com.jn.system.user.entity.TbSysGroup;
import com.jn.system.user.model.SysGroup;
import com.jn.system.user.model.SysGroupPage;
import com.jn.system.user.model.SysGroupUpdate;
import com.jn.system.user.vo.SysGroupUserRoleVO;

import java.util.List;

/**
 * 用户组dao
 *
 * @author： shaobao
 * @date： Created on 2018/10/30 15:30
 * @version： v1.0
 * @modified By:
 */
public interface SysGroupMapper {

    /**
     * 分页查询用户组信息
     *
     * @return
     */
    List<SysGroupUserRoleVO> findSysGroupAll(SysGroupPage groupPage);

    /**
     * 根据用户id对应用户组
     *
     * @param id
     * @return
     */
    List<SysGroup> findSysGroupByUserId(String id);

    /**
     * 增加用户组
     *
     * @param sysGroup
     */
    void addSysGroup(TbSysGroup sysGroup);

    /**
     * 逻辑删除用户组
     *
     * @param groupId
     */
    void deleSysGroup(String groupId);

    /**
     * 更新用户组信息
     *
     * @param sysGroup
     */
    void updateSysGroup(SysGroupUpdate sysGroup);

    /**
     * 根据用户组id获取用户组信息
     *
     * @param id 用户组id
     * @return
     */
    TbSysGroup findSysGroupById(String id);

    /**
     * 获取所有用户组信息
     *
     * @return
     */
    List<TbSysGroup> findGroupAll();

    /**
     * 批量删除用户组信息
     *
     * @param groupIds
     */
    void deleteGroupBranch(String[] groupIds);

    /**
     * 根据id获取用户组信息
     * @param id
     * @return
     */
    SysGroup getUserGroupById(String id);
}

package com.jn.system.user.dao;

import com.jn.system.user.entity.TbSysGroup;
import com.jn.system.user.model.SysGroup;
import com.jn.system.user.model.SysGroupPage;
import com.jn.system.user.vo.SysGroupUserRoleVO;

import java.util.List;
import java.util.Map;

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
     * 逻辑删除用户组
     *
     * @param groupId
     */
    void deleSysGroup(String groupId);

    /**
     * 根据用户组id获取用户组信息
     *
     * @param id 用户组id
     * @return
     */
    TbSysGroup findSysGroupById(String id);

    /**
     * 批量删除用户组信息
     *
     * @param map
     */
    void deleteGroupBranch(Map<String,Object> map);
}

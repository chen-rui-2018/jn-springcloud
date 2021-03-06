package com.jn.system.user.dao;

import com.jn.system.user.model.SysGroup;
import com.jn.system.user.model.SysGroupUser;
import com.jn.system.user.model.SysGroupUserPage;
import com.jn.system.user.model.SysTUser;
import com.jn.system.user.model.SysUserGroupPage;

import java.util.List;
import java.util.Map;

/**
 * 用户组关联用户mapper
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 18:58
 * @version： v1.0
 * @modified By:
 **/
public interface SysGroupUserMapper {

    /**
     * 根据用户组id获取该用户组下用户信息
     *
     * @param id
     * @return
     */
    List<SysTUser> findUserByGroupId(String id);

    /**
     * 根据用户组id获取该用户组下用户信息
     *
     * @param id
     * @return
     */
    List<String> findUsersByGroupId(String id);

    /**
     * 分页查询用户组已经具有的用户以外的用户
     *
     * @param sysGroupUserPage
     * @return
     */
    List<SysTUser> findOtherUserByPage(SysGroupUserPage sysGroupUserPage);

    /**
     * 用户组下面添加新的用户
     *
     * @param sysGroupUserList
     */
    void insertSysGroupUserBatch(List<SysGroupUser> sysGroupUserList);

    /**
     * 根据用户组id批量删除对应信息
     *
     * @param map
     */
    void deleteGroupBranch(Map<String,Object> map);

    /**
     * 根据用户id批量删除用户对应的信息
     *
     * @param map
     */
    void deleteUserBranch(Map<String,Object> map);

    /**
     * 条件分页获取用户为拥有的用户组信息
     *
     * @param sysUserGroupPage
     * @return
     */
    List<SysGroup> findGroupByPage(SysUserGroupPage sysUserGroupPage);

    /**
     * 批量添加用户用户组信息
     * @param list
     */
    void addGroupToUser(List<SysGroupUser> list);
}

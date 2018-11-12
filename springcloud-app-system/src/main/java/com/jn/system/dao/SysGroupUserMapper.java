package com.jn.system.dao;

import com.jn.system.model.SysGroupUser;
import com.jn.system.model.SysGroupUserPage;
import com.jn.system.model.SysTUser;
import com.jn.system.vo.SysUserVO;

import java.util.List;

/**
 * 用户组关联用户mapper
 * @author： shaobao
 * @date： Created on 2018/11/5 18:58
 * @version： v1.0
 * @modified By:
 **/
public interface SysGroupUserMapper {

    /**
     * 根据用户组id获取该用户组下用户信息
     * @param id
     * @return
     */
    List<SysTUser> findUserByGroupId(String id);

    /**
     * 根据用户组id获取该用户组下用户信息
     * @param id
     * @return
     */
    List<String> findUsersByGroupId(String id);

    /**
     * 分页查询用户组已经具有的用户以外的用户
     * @param sysGroupUserPage
     * @return
     */
    List<SysTUser> findOtherUserByPage(SysGroupUserPage sysGroupUserPage);

    /**
     * 逻辑删除用户组下面已经具有的用户
     * @param groupId
     */
    void deleteUserOfGroup(String groupId);

    /**
     * 用户组下面添加新的用户
     * @param sysGroupUserList
     */
    void insertSysGroupUserBatch(List<SysGroupUser> sysGroupUserList);

    /**
     * 根据用户组id批量删除对应信息
     * @param groupIds
     */
    void deleteGroupBranch(String[] groupIds);

    /**
     * 根据用户id批量删除用户对应的信息
     * @param ids
     */
    void deleteUserBranch(String[] ids);
}

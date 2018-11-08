package com.jn.system.dao;

import com.jn.system.entity.TbSysUserDepartmentPost;
import com.jn.system.model.SysDepartmentUserPage;
import com.jn.system.model.SysTUser;

import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2018/11/7 19:45
 * @version： v1.0
 * @modified By:
 **/
public interface SysUserDepartmentPostMapper {

    /**
     * 根据部门id获取部门下面所有用户
     * @param id
     * @return
     */
    List<SysTUser> fingUserOfDepartment(String id);

    /**
     * 条件分页查询部门具有的用户以外的用户信息
     * @param sysDepartmentUserPage
     * @return
     */
    List<SysTUser> fingOtherUserByPage(SysDepartmentUserPage sysDepartmentUserPage);

    /**
     * 清除部门下面原有用户
     * @param departmentId
     */
    void deleteUserOfDepartment(String departmentId);

    /**
     * 为部门批量添加用户信息
     * @param list
     */
    void insert(List<TbSysUserDepartmentPost> list);

    /**
     * 根据岗位id获取岗位上用户
     * @param id
     * @return
     */
    List<SysTUser> findUserByPostId(String id);

    /**
     * 批量删除岗位id
     * @param ids
     */
    void deletePostBranch(String[] ids);

    /**
     * 根据部门id批量删除部门信息
     * @param ids
     */
    void deleteDepartmentBranch(String[] ids);

    /**
     * 批量删除用户对应的信息
     * @param ids
     */
    void deleteUserBranch(String[] ids);
}

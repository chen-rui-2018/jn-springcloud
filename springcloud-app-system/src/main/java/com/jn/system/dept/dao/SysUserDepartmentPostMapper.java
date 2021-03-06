package com.jn.system.dept.dao;

import com.jn.system.dept.entity.TbSysDepartment;
import com.jn.system.dept.model.SysDepartmentUserPage;
import com.jn.system.user.model.SysTUser;
import com.jn.system.vo.SysDepartmentPostVO;

import java.util.List;
import java.util.Map;

/**
 * @author： shaobao
 * @date： Created on 2018/11/7 19:45
 * @version： v1.0
 * @modified By:
 **/
public interface SysUserDepartmentPostMapper {

    /**
     * 根据部门id获取部门下面所有用户
     *
     * @param id
     * @return
     */
    List<SysTUser> fingUserOfDepartment(String id);

    /**
     * 条件分页查询部门具有的用户以外的用户信息
     *
     * @param sysDepartmentUserPage
     * @return
     */
    List<SysTUser> fingOtherUserByPage(SysDepartmentUserPage sysDepartmentUserPage);

    /**
     * 清除部门下面原有用户
     *
     * @param departmentId
     */
    void deleteUserOfDepartment(String departmentId);

    /**
     * 根据岗位id获取岗位上用户
     *
     * @param id
     * @return
     */
    List<SysTUser> findUserByPostId(String id);

    /**
     * 批量删除岗位id
     *
     * @param map
     */
    void deletePostBranch(Map<String, Object> map);

    /**
     * 根据部门id批量删除部门信息
     *
     * @param map
     */
    void deleteDepartmentBranch(Map<String, Object> map);

    /**
     * 批量删除用户对应的信息
     *
     * @param map
     */
    void deleteUserBranch(Map<String, Object> map);

    /**
     * 根据部门id递归获取部门及上级部门信息
     *
     * @param departmentId
     * @return
     */
    List<TbSysDepartment> findDepartmentId(String departmentId);

    /**
     * 根据用户id获取用户已经具有的部门岗位信息
     *
     * @param userId
     * @return
     */
    List<SysDepartmentPostVO> findDepartmentAndPostByUserId(String userId);
}

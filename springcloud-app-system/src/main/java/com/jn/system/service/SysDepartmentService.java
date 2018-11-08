package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.entity.TbSysDepartment;
import com.jn.system.model.*;

/**
 * @author： shaobao
 * @date： Created on 2018/10/31 17:07
 * @version： v1.0
 * @modified By:
 **/
public interface SysDepartmentService {
    /**
     * 返回所有部门信息
     * @return
     */
    Result findSysDepartmentAll();

    /**
     * 根据部门id获取部门信息
     * @param id
     * @return
     */
    Result selectByPrimaryKey(String id);

    /**
     * 逻辑删除部门信息
     * @param ids
     */
    void delete(String[] ids);

    /**
     * 修改部门信息
     * @param sysDepartment
     */
    void update(SysDepartment sysDepartment);

    /**
     * 添加部门信息
     * @param sysDepartmentAdd
     */
    void add(SysDepartmentAdd sysDepartmentAdd);

    /**
     * 条件分页查询部门信息
     * @param sysDepartmentPage
     * @return
     */
    Result findSysDepartmentByPage(SysDepartmentPage sysDepartmentPage);

    /**
     * 根据部门id获取部门已经存在的用户信息
     * @param departmentId
     * @return
     */
    Result findUserOfDepartment(String departmentId);

    /**
     * 条件分页查询部门具有的用户以外的用户信息
     * @param sysDepartmentUserPage
     * @return
     */
    Result fingOtherUserByPage(SysDepartmentUserPage sysDepartmentUserPage);

    /**
     * 为部门添加用户
     * @param sysDepartmentUserAdd
     */
    void addUserToDepartment(SysDepartmentUserAdd sysDepartmentUserAdd);
}

package com.jn.system.dept.service;

import com.jn.common.model.Result;
import com.jn.system.dept.entity.TbSysDepartment;
import com.jn.system.dept.model.SysDepartment;
import com.jn.system.dept.model.SysDepartmentCheckName;
import com.jn.system.dept.vo.SysDepartmentVO;
import com.jn.system.model.User;

import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2018/10/31 17:07
 * @version： v1.0
 * @modified By:
 **/
public interface SysDepartmentService {

    /**
     * 根据部门id获取当前部门及所有子部门信息
     *
     * @param id         部门id
     * @param isGetChild true 表示获取所有子部门，false表示只获取当前部门
     * @return
     */
    Result selectDeptByKey(String id, Boolean isGetChild);

    /**
     * 逻辑删除部门信息
     *
     * @param id
     * @param user 当前用户信息
     */
    void delete(String id, User user);

    /**
     * 修改部门信息
     *
     * @param sysDepartment
     * @param user
     */
    void update(SysDepartment sysDepartment, User user);

    /**
     * 添加部门
     *
     * @param tbSysDepartment
     */
    void add(TbSysDepartment tbSysDepartment);


    /**
     * 校验同级部门中部门名称是否存在
     *
     * @param sysDepartmentCheckName
     * @return
     */
    String checkDepartmentName(SysDepartmentCheckName sysDepartmentCheckName);

    /**
     * 查询所有部门信息,并根据层级关系返回
     *
     * @return
     */
    List<SysDepartmentVO> findDepartmentAllByLevel();

    /**
     * 批量更新部门信息
     *
     * @param sysDepartmentList
     * @param user              当前用户信息
     */
    void addDepartmentBatch(List<SysDepartment> sysDepartmentList, User user);

    /**
     * 根据父级id获取所有子部门信息
     *
     * @param parentId
     * @return
     */
    List<SysDepartmentVO> getChildDepartmentByParentId(String parentId);

    /**
     * 要查询的部门ID是否属于用户所属的部门或子部门
     *
     * @param userId 用户id
     * @param deptId 部门id
     * @return
     */
    Boolean checkUserDept(String userId, String deptId);

    /**
     * 根据部门名称,获取部门信息
     *
     * @param deptName
     * @return
     */
    TbSysDepartment getDept(String deptName);
}

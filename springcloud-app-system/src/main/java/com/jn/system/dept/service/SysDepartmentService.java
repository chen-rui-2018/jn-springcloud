package com.jn.system.dept.service;

import com.jn.common.model.PaginationData;
import com.jn.system.dept.model.SysDepartment;
import com.jn.system.dept.model.SysDepartmentAdd;
import com.jn.system.dept.model.SysDepartmentCheckName;
import com.jn.system.dept.model.SysDepartmentPage;
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
     * 根据部门id获取部门信息
     *
     * @param id
     * @return
     */
    SysDepartment selectByPrimaryKey(String id);

    /**
     * 逻辑删除部门信息
     *
     * @param id
     */
    void delete(String id);

    /**
     * 修改部门信息
     *
     * @param sysDepartment
     */
    void update(SysDepartment sysDepartment);

    /**
     * 添加部门
     *
     * @param sysDepartmentAdd
     */
    void add(SysDepartmentAdd sysDepartmentAdd, User user);


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
     * 批量添加更新部门信息
     *
     * @param sysDepartmentList
     * @param user
     */
    void addDepartmentBatch(List<SysDepartment> sysDepartmentList, User user);
}

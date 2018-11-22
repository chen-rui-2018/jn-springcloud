package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.entity.TbSysDepartment;
import com.jn.system.model.*;
import com.jn.system.vo.SysDepartmentVO;

import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2018/10/31 17:07
 * @version： v1.0
 * @modified By:
 **/
public interface SysDepartmentService {
    /**
     * 返回所有部门信息
     *
     * @return
     */
    List<SysDepartment> findSysDepartmentAll();

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
     * @param ids
     */
    void delete(String[] ids);

    /**
     * 修改部门信息
     *
     * @param sysDepartment
     */
    void update(SysDepartment sysDepartment);

    /**
     * 添加部门信息
     *
     * @param sysDepartmentAdd
     */
    void add(SysDepartmentAdd sysDepartmentAdd,User user);

    /**
     * 条件分页查询部门信息
     *
     * @param sysDepartmentPage
     * @return
     */
    PaginationData findSysDepartmentByPage(SysDepartmentPage sysDepartmentPage);


    /**
     * 判断部门名称是否存在
     *
     * @param departmentName
     * @return
     */
    String checkDepartmentName(String departmentName);

    /**
     * 查询所有部门信息,并根据层级关系返回
     *
     * @return
     */
    List<SysDepartmentVO> findDepartmentAllByLevel();
}

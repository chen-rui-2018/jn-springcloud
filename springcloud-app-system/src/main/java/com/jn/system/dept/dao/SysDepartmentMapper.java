package com.jn.system.dept.dao;

import com.jn.system.dept.model.SysDepartmentPage;
import com.jn.system.dept.vo.SysDepartmentUserVO;
import com.jn.system.dept.vo.SysDepartmentVO;

import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2018/11/8 0:08
 * @version： v1.0
 * @modified By:
 **/
public interface SysDepartmentMapper {

    /**
     * 条件分页获取信息
     *
     * @param sysDepartmentPage
     * @return
     */
    List<SysDepartmentUserVO> findSysDepartmentByPage(SysDepartmentPage sysDepartmentPage);

    /**
     * 批量删除部门
     *
     * @param ids
     */
    void deleteDepartmentBranch(String[] ids);

    /**
     * 获取一级部门信息
     *
     * @return
     */
    List<SysDepartmentVO> findSysDepartmentAll();

    /**
     * 根据父id查询所有子部门
     * @param departmentId
     * @return
     */
    List<SysDepartmentVO> findChildrenDepartment(String departmentId);
}

package com.jn.system.dept.dao;

import com.jn.system.dept.entity.TbSysDepartment;
import com.jn.system.dept.model.SysDepartment;
import com.jn.system.dept.model.SysDepartmentCheckName;
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
     * 批量删除部门
     *
     * @param ids
     */
    void deleteDepartmentBranch(List<String> ids);

    /**
     * 获取一级部门信息
     *
     * @return
     */
    List<SysDepartmentVO> findSysDepartmentAll();

    /**
     * 根据父id查询所有子部门
     *
     * @param departmentId
     * @return
     */
    List<SysDepartmentVO> findChildrenDepartment(String departmentId);

    /**
     * 批量添加部门信息
     *
     * @param addeList
     */
    void addDepartmentBatch(List<TbSysDepartment> addeList);

    /**
     * 批量更新部门信息
     *
     * @param list
     */
    void updateDepartmentBatch(List<SysDepartment> list);

    /**
     * 根据父级id获取所有子部门信息
     *
     * @param parentId
     * @return
     */
    List<SysDepartmentVO> getChildDepartmentByParentId(String parentId);
}

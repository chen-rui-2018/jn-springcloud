package com.jn.system.dept.dao;

import com.jn.system.dept.vo.SysDepartmentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
     * @param map
     */
    void deleteDepartmentBranch(Map<String, Object> map);

    /**
     * 批量更新部门信息
     */
    void updateDepartmentBatch(Map<String, Object> map);

    /**
     * 根据父级id获取所有子部门信息
     *
     * @param parentId
     * @return
     */
    List<SysDepartmentVO> getChildDepartmentByParentId(String parentId);

    /**
     * 获取所有部门信息
     *
     * @return
     */
    List<SysDepartmentVO> getDepartmentAll(@Param("level") String level);

    /**
     * 获取部门及子部门id
     *
     * @param id
     * @return
     */
    String getDepartmentIds(String id);

    /**
     * 根据部门id获取部门信息
     *
     * @param id 部门id
     * @return
     */
    SysDepartmentVO selectByPrimaryKey(String id);

    /**
     * 获取部门的所有子部门信息
     *
     * @param id 部门id
     * @return
     */
    List<SysDepartmentVO> getChildDept(String id);
}

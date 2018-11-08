package com.jn.system.dao;

import com.jn.system.model.SysDepartmentPage;
import com.jn.system.vo.SysDepartmentVO;

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
     * @param sysDepartmentPage
     * @return
     */
    List<SysDepartmentVO> findSysDepartmentByPage(SysDepartmentPage sysDepartmentPage);

    /**
     * 批量删除部门
     * @param ids
     */
    void deleteDepartmentBranch(String[] ids);
}

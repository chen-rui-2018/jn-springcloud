package com.jn.system.dao;

import com.jn.system.model.SysDepartment;

import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2018/10/31 17:09
 * @version： v1.0
 * @modified By:
 **/
public interface SysDepartmentMapper {
    /**
     * 获取所有部门列表
     * @return
     */
    List<SysDepartment> findSysDepartmentAll();

}

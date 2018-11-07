package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.entity.TbSysDepartment;

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
     * @param tbSysDepartment
     */
    void update(TbSysDepartment tbSysDepartment);
}

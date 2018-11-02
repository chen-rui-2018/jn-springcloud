package com.jn.system.dao;

import com.jn.common.model.Result;
import com.jn.system.vo.TbSysPost;

import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2018/10/31 16:01
 * @version： v1.0
 * @modified By:
 **/
public interface SysPostMapper {

    /**
     * 获取所有岗位信息
     * @return
     */
    public List<TbSysPost> findSysPostAll();

    /**
     * 根据部门id获取所有岗位信息
     * @param departmentId
     * @return
     */
    List<TbSysPost> findSysPostByDepartmentId(String departmentId);
}

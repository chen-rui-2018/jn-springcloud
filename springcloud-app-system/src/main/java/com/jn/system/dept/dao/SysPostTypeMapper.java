package com.jn.system.dept.dao;

import com.jn.system.dept.model.SysPostType;
import com.jn.system.dept.model.SysPostTypePage;

import java.util.List;

/**
 * 岗位类型持久层
 * @author： shaobao
 * @date： Created on 2019/2/20 15:37
 * @version： v1.0
 * @modified By:
 **/
public interface SysPostTypeMapper {

    /**
     * 条件分页获取岗位类型信息
     * @param postTypePage
     * @return
     */
    List<SysPostType> getPostTypeByPage(SysPostTypePage postTypePage);
}

package com.jn.system.dept.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.dept.entity.TbSysPostType;
import com.jn.system.dept.model.SysPostType;
import com.jn.system.dept.model.SysPostTypeAdd;
import com.jn.system.dept.model.SysPostTypePage;
import com.jn.system.model.User;

import java.util.List;

/**
 * 岗位管理service
 *
 * @author： shaobao
 * @date： Created on 2018/12/10 11:37
 * @version： v1.0
 * @modified By:
 **/
public interface SysPostTypeService {

    /**
     * 增加岗位类型
     *
     * @param postTypeAdd 岗位类型增加实体
     */
    void add(SysPostTypeAdd postTypeAdd, User user);

    /**
     * 列表查询岗位类型
     *
     * @param postTypePage 岗位类型分页实体
     * @return
     */
    PaginationData getPostTypeByPage(SysPostTypePage postTypePage);

    /**
     * 校验岗位类型名称是否存在
     *
     * @param postTypeName 岗位类型分页实体
     * @return
     */
    String checkPostTypeName(String postTypeName);

    /**
     * 修改岗位类型
     *
     * @param postType 岗位类型实体
     */
    void update(SysPostType postType);

    /**
     * 删除岗位类型
     *
     * @param postTypeId 岗位类型id
     * @return
     */
    Result delete(String postTypeId);

    /**
     * 获取所有岗位类型
     *
     * @return
     */
    List<TbSysPostType> getPostTypeAll();
}

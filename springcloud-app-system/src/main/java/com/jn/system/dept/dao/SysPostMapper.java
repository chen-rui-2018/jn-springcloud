package com.jn.system.dept.dao;

import com.jn.system.dept.model.SysPost;
import com.jn.system.dept.model.SysPostPage;

import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2018/11/8 16:50
 * @version： v1.0
 * @modified By:
 **/
public interface SysPostMapper {
    /**
     * 批量删除岗位
     *
     * @param ids
     */
    void deletePostBranch(String[] ids);

    /**
     * 条件分页获取岗位信息
     *
     * @param sysPostPage
     * @return
     */
    List<SysPost> findByPage(SysPostPage sysPostPage);
}

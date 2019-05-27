package com.jn.system.dept.dao;

import com.jn.system.model.SysPost;
import com.jn.system.dept.model.SysPostPage;

import java.util.List;
import java.util.Map;

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
     * @param map
     */
    void deletePostBranch(Map<String, Object> map);

    /**
     * 条件分页获取岗位信息
     *
     * @param sysPostPage
     * @return
     */
    List<SysPost> findByPage(SysPostPage sysPostPage);

    /**
     * 获取所有岗位信息
     *
     * @return
     */
    List<SysPost> getPostAll();
}

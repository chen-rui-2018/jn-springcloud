package com.jn.system.dept.service;

import com.jn.common.model.PaginationData;
import com.jn.system.dept.entity.TbSysPost;
import com.jn.system.dept.model.SysPost;
import com.jn.system.dept.model.SysPostAdd;
import com.jn.system.dept.model.SysPostPage;
import com.jn.system.model.User;

import java.util.List;

/**
 * 岗位service
 *
 * @author： shaobao
 * @date： Created on 2018/10/31 15:54
 * @version： v1.0
 * @modified By:
 **/
public interface SysPostService {
    /**
     * 查询所有岗位
     *
     * @return
     */
    List<TbSysPost> findSysPostAll();

    /**
     * 添加岗位
     *
     * @param sysPostAdd
     */
    void addPost(SysPostAdd sysPostAdd, User user);

    /**
     * 批量删除岗位
     *
     * @param ids
     */
    void deletePostBranch(String[] ids);

    /**
     * 修改岗位信息
     *
     * @param sysPost
     */
    void updatePost(SysPost sysPost);

    /**
     * 根据岗位id获取岗位信息
     *
     * @param id
     * @return
     */
    SysPost selectByPrimaryKey(String id);

    /**
     * 条件分页获取岗位信息列表
     *
     * @param sysPostPage
     * @return
     */
    PaginationData findByPage(SysPostPage sysPostPage);

    /**
     *  校验岗位名称是否已存在
     * @param postName
     * @return
     */
    String checkPostName(String postName);
}

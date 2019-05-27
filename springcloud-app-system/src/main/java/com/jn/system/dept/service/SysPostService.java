package com.jn.system.dept.service;

import com.jn.common.model.PaginationData;
import com.jn.system.dept.entity.TbSysPost;
import com.jn.system.model.SysPost;
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
    List<SysPost> findSysPostAll();

    /**
     * 添加岗位
     *
     * @param tbSysPost
     */
    void addPost(TbSysPost tbSysPost);

    /**
     * 删除岗位信息
     *
     * @param ids
     * @param user 当前用户信息
     */
    void deletePostBranch(String[] ids, User user);

    /**
     * 修改岗位信息
     *
     * @param sysPost
     * @param user    当前用户信息
     */
    void updatePost(SysPost sysPost, User user);

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
     * 校验岗位名称是否已存在
     *
     * @param postName
     * @return
     */
    String checkPostName(String postName);
}

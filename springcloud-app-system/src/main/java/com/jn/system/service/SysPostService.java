package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.entity.TbSysPost;
import com.jn.system.model.SysPost;
import com.jn.system.model.SysPostAdd;
import com.jn.system.model.SysPostPage;

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
    void addPost(SysPostAdd sysPostAdd);

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
     * 分页获取岗位信息及对应的用户
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

package com.jn.system.dao;

import com.jn.system.model.SysPost;
import com.jn.system.model.SysPostPage;
import com.jn.system.vo.SysPostVO;

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
     * @param ids
     */
    void deletePostBranch(String[] ids);

    /**
     * 修改岗位信息
     * @param sysPost
     */
    void updatePost(SysPost sysPost);

    /**
     * 条件分页获取岗位信息
     * @param sysPostPage
     * @return
     */
    List<SysPostVO> findByPage(SysPostPage sysPostPage);
}

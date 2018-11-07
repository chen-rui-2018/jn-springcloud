package com.jn.system.dao;


import com.jn.system.model.SysResources;
import com.jn.system.model.SysResourcesPage;
import com.jn.system.vo.SysResourcesVO;

import java.util.List;

/**
 * 功能mapper
 *
 * @author： yuanyy
 * @date： Created on 2018/11/05 15:31
 * @version： v1.0
 * @modified By:
 */
public interface SysResourcesMapper {


    /**
     * 根据ids批量删除
     * @param id
     */
    void deleteByIds(String[] id);

    /**
     * 根据主键查询功能菜单列表
     * @param sysResourcesPage
     * @return
     */
    List<SysResourcesVO> findMenuResourcesByPage(SysResourcesPage sysResourcesPage);


}
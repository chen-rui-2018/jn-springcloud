package com.jn.system.file.dao;


import com.jn.system.file.model.SysFileGroup;
import com.jn.system.file.model.SysFileGroupPage;

import java.util.List;
import java.util.Map;

/**
 * 文件组mapper
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
public interface SysFileGroupMapper {

    /**
     * 批量删除
     *
     * @param map
     * @return
     */
    int deleteByIds(Map<String, Object> map);

    /**
     * 条件分页获取文件组列表
     * @param sysFileGroupPage
     * @return
     */
    List<SysFileGroup> getFileGroupByPage(SysFileGroupPage sysFileGroupPage);
}
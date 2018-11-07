package com.jn.system.dao;


import com.jn.system.model.SysFileGroupFile;

import java.util.List;

/**
 * 文件文件组关联mapper
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
public interface SysFileGroupFileMapper {
    /**
     * 批量删除
     * @param id
     * @return
     */
    int deleteByIds(String[] id);

    /**
     * 根据fileId批量删除
     * @param id
     * @return
     */
    int deleteByFileIds(String[] id);

    /**
     * 根据fileId批量删除
     * @param id
     * @return
     */
    int deleteByFileGroupIds(String[] id);

    /**
     * 批量插入文件组文件
     * @param sysFileGroupFiles
     * @return
     */
    int insertBatch(List<SysFileGroupFile> sysFileGroupFiles);
}
package com.jn.system.file.dao;


import com.jn.system.file.model.SysFileGroup;

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
     * @param id
     * @return
     */
    int deleteByIds(String[] id);


    /**
     * 判断文件组是否存在
     * @param id
     * @return
     */
    SysFileGroup getFileGroupById(String id);
}
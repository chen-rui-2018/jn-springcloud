package com.jn.system.file.dao;


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
}
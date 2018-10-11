package com.jn.system.dao;

import com.jn.system.model.Resources;

import java.util.List;
/**
 * 资源
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public interface ResourcesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Resources record);

    Resources selectByPrimaryKey(String id);

    List<Resources> selectAll();

    int updateByPrimaryKey(Resources record);

    void deleteBy(String[] id);

}
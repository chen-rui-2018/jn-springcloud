package com.jn.system.dao;

import com.jn.system.model.Resources;
import com.jn.system.model.RoleResources;

import java.util.List;
/**
 * 角色资源
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public interface RoleResourcesMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleResources record);

    RoleResources selectByPrimaryKey(String id);

    List<RoleResources> selectAll();

    int updateByPrimaryKey(RoleResources record);

    void deleteByT(RoleResources[] roleResources);

    List<RoleResources> findTByT(RoleResources roleResources);

    List<Resources> findResourcesByT(Resources resources);
}
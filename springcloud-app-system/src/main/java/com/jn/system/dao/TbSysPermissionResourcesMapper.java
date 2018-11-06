package com.jn.system.dao;

import com.jn.system.entity.TbSysPermissionResources;
import com.jn.system.entity.TbSysPermissionResourcesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysPermissionResourcesMapper {
    long countByExample(TbSysPermissionResourcesCriteria example);

    int deleteByExample(TbSysPermissionResourcesCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysPermissionResources record);

    int insertSelective(TbSysPermissionResources record);

    List<TbSysPermissionResources> selectByExample(TbSysPermissionResourcesCriteria example);

    TbSysPermissionResources selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysPermissionResources record, @Param("example") TbSysPermissionResourcesCriteria example);

    int updateByExample(@Param("record") TbSysPermissionResources record, @Param("example") TbSysPermissionResourcesCriteria example);

    int updateByPrimaryKeySelective(TbSysPermissionResources record);

    int updateByPrimaryKey(TbSysPermissionResources record);
}
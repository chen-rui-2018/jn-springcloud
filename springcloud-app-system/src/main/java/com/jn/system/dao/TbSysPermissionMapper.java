package com.jn.system.dao;

import com.jn.system.entity.TbSysPermission;
import com.jn.system.entity.TbSysPermissionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysPermissionMapper {
    long countByExample(TbSysPermissionCriteria example);

    int deleteByExample(TbSysPermissionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysPermission record);

    int insertSelective(TbSysPermission record);

    List<TbSysPermission> selectByExample(TbSysPermissionCriteria example);

    TbSysPermission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysPermission record, @Param("example") TbSysPermissionCriteria example);

    int updateByExample(@Param("record") TbSysPermission record, @Param("example") TbSysPermissionCriteria example);

    int updateByPrimaryKeySelective(TbSysPermission record);

    int updateByPrimaryKey(TbSysPermission record);
}
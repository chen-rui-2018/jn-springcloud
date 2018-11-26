package com.jn.system.permission.dao;

import com.jn.system.permission.entity.TbSysRolePermission;
import com.jn.system.permission.entity.TbSysRolePermissionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysRolePermissionMapper {
    long countByExample(TbSysRolePermissionCriteria example);

    int deleteByExample(TbSysRolePermissionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysRolePermission record);

    int insertSelective(TbSysRolePermission record);

    List<TbSysRolePermission> selectByExample(TbSysRolePermissionCriteria example);

    TbSysRolePermission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysRolePermission record, @Param("example") TbSysRolePermissionCriteria example);

    int updateByExample(@Param("record") TbSysRolePermission record, @Param("example") TbSysRolePermissionCriteria example);

    int updateByPrimaryKeySelective(TbSysRolePermission record);

    int updateByPrimaryKey(TbSysRolePermission record);
}
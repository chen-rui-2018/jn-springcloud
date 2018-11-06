package com.jn.system.dao;

import com.jn.system.entity.TbSysPermissionMenu;
import com.jn.system.entity.TbSysPermissionMenuCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysPermissionMenuMapper {
    long countByExample(TbSysPermissionMenuCriteria example);

    int deleteByExample(TbSysPermissionMenuCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysPermissionMenu record);

    int insertSelective(TbSysPermissionMenu record);

    List<TbSysPermissionMenu> selectByExample(TbSysPermissionMenuCriteria example);

    TbSysPermissionMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysPermissionMenu record, @Param("example") TbSysPermissionMenuCriteria example);

    int updateByExample(@Param("record") TbSysPermissionMenu record, @Param("example") TbSysPermissionMenuCriteria example);

    int updateByPrimaryKeySelective(TbSysPermissionMenu record);

    int updateByPrimaryKey(TbSysPermissionMenu record);
}
package com.jn.system.menu.dao;

import com.jn.system.menu.entity.TbSysMenu;
import com.jn.system.menu.entity.TbSysMenuCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysMenuMapper {
    long countByExample(TbSysMenuCriteria example);

    int deleteByExample(TbSysMenuCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysMenu record);

    int insertSelective(TbSysMenu record);

    List<TbSysMenu> selectByExample(TbSysMenuCriteria example);

    TbSysMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysMenu record, @Param("example") TbSysMenuCriteria example);

    int updateByExample(@Param("record") TbSysMenu record, @Param("example") TbSysMenuCriteria example);

    int updateByPrimaryKeySelective(TbSysMenu record);

    int updateByPrimaryKey(TbSysMenu record);
}
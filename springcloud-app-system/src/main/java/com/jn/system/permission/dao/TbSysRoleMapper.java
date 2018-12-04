package com.jn.system.permission.dao;

import com.jn.system.permission.entity.TbSysRole;
import com.jn.system.permission.entity.TbSysRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysRoleMapper {
    long countByExample(TbSysRoleCriteria example);

    int deleteByExample(TbSysRoleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysRole record);

    int insertSelective(TbSysRole record);

    List<TbSysRole> selectByExample(TbSysRoleCriteria example);

    TbSysRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysRole record, @Param("example") TbSysRoleCriteria example);

    int updateByExample(@Param("record") TbSysRole record, @Param("example") TbSysRoleCriteria example);

    int updateByPrimaryKeySelective(TbSysRole record);

    int updateByPrimaryKey(TbSysRole record);
}
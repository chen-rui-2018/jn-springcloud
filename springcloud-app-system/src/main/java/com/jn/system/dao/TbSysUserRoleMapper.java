package com.jn.system.dao;

import com.jn.system.entity.TbSysUserRole;
import com.jn.system.entity.TbSysUserRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUserRoleMapper {
    long countByExample(TbSysUserRoleCriteria example);

    int deleteByExample(TbSysUserRoleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysUserRole record);

    int insertSelective(TbSysUserRole record);

    List<TbSysUserRole> selectByExample(TbSysUserRoleCriteria example);

    TbSysUserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysUserRole record, @Param("example") TbSysUserRoleCriteria example);

    int updateByExample(@Param("record") TbSysUserRole record, @Param("example") TbSysUserRoleCriteria example);

    int updateByPrimaryKeySelective(TbSysUserRole record);

    int updateByPrimaryKey(TbSysUserRole record);
}
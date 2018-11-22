package com.jn.system.user.dao;

import com.jn.system.user.entity.TbSysGroupRole;
import com.jn.system.user.entity.TbSysGroupRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysGroupRoleMapper {
    long countByExample(TbSysGroupRoleCriteria example);

    int deleteByExample(TbSysGroupRoleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysGroupRole record);

    int insertSelective(TbSysGroupRole record);

    List<TbSysGroupRole> selectByExample(TbSysGroupRoleCriteria example);

    TbSysGroupRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysGroupRole record, @Param("example") TbSysGroupRoleCriteria example);

    int updateByExample(@Param("record") TbSysGroupRole record, @Param("example") TbSysGroupRoleCriteria example);

    int updateByPrimaryKeySelective(TbSysGroupRole record);

    int updateByPrimaryKey(TbSysGroupRole record);
}
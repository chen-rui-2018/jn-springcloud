package com.jn.system.dao;

import com.jn.system.entity.TbSysUserGroup;
import com.jn.system.entity.TbSysUserGroupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUserGroupMapper {
    long countByExample(TbSysUserGroupCriteria example);

    int deleteByExample(TbSysUserGroupCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysUserGroup record);

    int insertSelective(TbSysUserGroup record);

    List<TbSysUserGroup> selectByExample(TbSysUserGroupCriteria example);

    TbSysUserGroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysUserGroup record, @Param("example") TbSysUserGroupCriteria example);

    int updateByExample(@Param("record") TbSysUserGroup record, @Param("example") TbSysUserGroupCriteria example);

    int updateByPrimaryKeySelective(TbSysUserGroup record);

    int updateByPrimaryKey(TbSysUserGroup record);
}
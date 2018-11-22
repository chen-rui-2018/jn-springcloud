package com.jn.system.user.dao;

import com.jn.system.user.entity.TbSysUser;
import com.jn.system.user.entity.TbSysUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUserMapper {
    long countByExample(TbSysUserCriteria example);

    int deleteByExample(TbSysUserCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysUser record);

    int insertSelective(TbSysUser record);

    List<TbSysUser> selectByExample(TbSysUserCriteria example);

    TbSysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysUser record, @Param("example") TbSysUserCriteria example);

    int updateByExample(@Param("record") TbSysUser record, @Param("example") TbSysUserCriteria example);

    int updateByPrimaryKeySelective(TbSysUser record);

    int updateByPrimaryKey(TbSysUser record);
}
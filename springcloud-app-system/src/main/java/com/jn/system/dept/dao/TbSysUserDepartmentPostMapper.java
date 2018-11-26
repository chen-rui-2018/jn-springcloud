package com.jn.system.dept.dao;

import com.jn.system.dept.entity.TbSysUserDepartmentPost;
import com.jn.system.dept.entity.TbSysUserDepartmentPostCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUserDepartmentPostMapper {
    long countByExample(TbSysUserDepartmentPostCriteria example);

    int deleteByExample(TbSysUserDepartmentPostCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysUserDepartmentPost record);

    int insertSelective(TbSysUserDepartmentPost record);

    List<TbSysUserDepartmentPost> selectByExample(TbSysUserDepartmentPostCriteria example);

    TbSysUserDepartmentPost selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysUserDepartmentPost record, @Param("example") TbSysUserDepartmentPostCriteria example);

    int updateByExample(@Param("record") TbSysUserDepartmentPost record, @Param("example") TbSysUserDepartmentPostCriteria example);

    int updateByPrimaryKeySelective(TbSysUserDepartmentPost record);

    int updateByPrimaryKey(TbSysUserDepartmentPost record);
}
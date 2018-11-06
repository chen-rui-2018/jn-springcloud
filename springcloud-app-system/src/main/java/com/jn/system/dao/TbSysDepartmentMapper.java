package com.jn.system.dao;

import com.jn.system.entity.TbSysDepartment;
import com.jn.system.entity.TbSysDepartmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysDepartmentMapper {
    long countByExample(TbSysDepartmentCriteria example);

    int deleteByExample(TbSysDepartmentCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysDepartment record);

    int insertSelective(TbSysDepartment record);

    List<TbSysDepartment> selectByExample(TbSysDepartmentCriteria example);

    TbSysDepartment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysDepartment record, @Param("example") TbSysDepartmentCriteria example);

    int updateByExample(@Param("record") TbSysDepartment record, @Param("example") TbSysDepartmentCriteria example);

    int updateByPrimaryKeySelective(TbSysDepartment record);

    int updateByPrimaryKey(TbSysDepartment record);
}
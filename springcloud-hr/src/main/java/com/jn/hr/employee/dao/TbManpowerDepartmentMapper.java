package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerDepartment;
import com.jn.hr.employee.entity.TbManpowerDepartmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerDepartmentMapper {
    long countByExample(TbManpowerDepartmentCriteria example);

    int deleteByExample(TbManpowerDepartmentCriteria example);

    int deleteByPrimaryKey(String departmentId);

    int insert(TbManpowerDepartment record);

    int insertSelective(TbManpowerDepartment record);

    List<TbManpowerDepartment> selectByExample(TbManpowerDepartmentCriteria example);

    TbManpowerDepartment selectByPrimaryKey(String departmentId);

    int updateByExampleSelective(@Param("record") TbManpowerDepartment record, @Param("example") TbManpowerDepartmentCriteria example);

    int updateByExample(@Param("record") TbManpowerDepartment record, @Param("example") TbManpowerDepartmentCriteria example);

    int updateByPrimaryKeySelective(TbManpowerDepartment record);

    int updateByPrimaryKey(TbManpowerDepartment record);
}
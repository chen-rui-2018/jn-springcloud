package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerRetirementManagement;
import com.jn.hr.employee.entity.TbManpowerRetirementManagementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerRetirementManagementMapper {
    long countByExample(TbManpowerRetirementManagementCriteria example);

    int deleteByExample(TbManpowerRetirementManagementCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerRetirementManagement record);

    int insertSelective(TbManpowerRetirementManagement record);

    List<TbManpowerRetirementManagement> selectByExample(TbManpowerRetirementManagementCriteria example);

    TbManpowerRetirementManagement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerRetirementManagement record, @Param("example") TbManpowerRetirementManagementCriteria example);

    int updateByExample(@Param("record") TbManpowerRetirementManagement record, @Param("example") TbManpowerRetirementManagementCriteria example);

    int updateByPrimaryKeySelective(TbManpowerRetirementManagement record);

    int updateByPrimaryKey(TbManpowerRetirementManagement record);
}
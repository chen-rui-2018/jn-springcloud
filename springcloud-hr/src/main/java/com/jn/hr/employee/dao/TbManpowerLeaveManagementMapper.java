package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerLeaveManagement;
import com.jn.hr.employee.entity.TbManpowerLeaveManagementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerLeaveManagementMapper {
    long countByExample(TbManpowerLeaveManagementCriteria example);

    int deleteByExample(TbManpowerLeaveManagementCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerLeaveManagement record);

    int insertSelective(TbManpowerLeaveManagement record);

    List<TbManpowerLeaveManagement> selectByExample(TbManpowerLeaveManagementCriteria example);

    TbManpowerLeaveManagement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerLeaveManagement record, @Param("example") TbManpowerLeaveManagementCriteria example);

    int updateByExample(@Param("record") TbManpowerLeaveManagement record, @Param("example") TbManpowerLeaveManagementCriteria example);

    int updateByPrimaryKeySelective(TbManpowerLeaveManagement record);

    int updateByPrimaryKey(TbManpowerLeaveManagement record);
}
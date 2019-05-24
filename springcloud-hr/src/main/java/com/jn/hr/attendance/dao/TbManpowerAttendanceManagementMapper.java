package com.jn.hr.attendance.dao;

import com.jn.hr.attendance.entity.TbManpowerAttendanceManagement;
import com.jn.hr.attendance.entity.TbManpowerAttendanceManagementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerAttendanceManagementMapper {
    long countByExample(TbManpowerAttendanceManagementCriteria example);

    int deleteByExample(TbManpowerAttendanceManagementCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerAttendanceManagement record);

    int insertSelective(TbManpowerAttendanceManagement record);

    List<TbManpowerAttendanceManagement> selectByExample(TbManpowerAttendanceManagementCriteria example);

    TbManpowerAttendanceManagement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerAttendanceManagement record, @Param("example") TbManpowerAttendanceManagementCriteria example);

    int updateByExample(@Param("record") TbManpowerAttendanceManagement record, @Param("example") TbManpowerAttendanceManagementCriteria example);

    int updateByPrimaryKeySelective(TbManpowerAttendanceManagement record);

    int updateByPrimaryKey(TbManpowerAttendanceManagement record);
}
package com.jn.hr.attendance.dao;

import com.jn.hr.attendance.entity.TbManpowerAttendanceTimeSet;
import com.jn.hr.attendance.entity.TbManpowerAttendanceTimeSetCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerAttendanceTimeSetMapper {
    long countByExample(TbManpowerAttendanceTimeSetCriteria example);

    int deleteByExample(TbManpowerAttendanceTimeSetCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerAttendanceTimeSet record);

    int insertSelective(TbManpowerAttendanceTimeSet record);

    List<TbManpowerAttendanceTimeSet> selectByExample(TbManpowerAttendanceTimeSetCriteria example);

    TbManpowerAttendanceTimeSet selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerAttendanceTimeSet record, @Param("example") TbManpowerAttendanceTimeSetCriteria example);

    int updateByExample(@Param("record") TbManpowerAttendanceTimeSet record, @Param("example") TbManpowerAttendanceTimeSetCriteria example);

    int updateByPrimaryKeySelective(TbManpowerAttendanceTimeSet record);

    int updateByPrimaryKey(TbManpowerAttendanceTimeSet record);
}
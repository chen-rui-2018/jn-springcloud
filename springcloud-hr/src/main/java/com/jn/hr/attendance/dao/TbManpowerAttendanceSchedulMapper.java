package com.jn.hr.attendance.dao;

import com.jn.hr.attendance.entity.TbManpowerAttendanceSchedul;
import com.jn.hr.attendance.entity.TbManpowerAttendanceSchedulCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerAttendanceSchedulMapper {
    long countByExample(TbManpowerAttendanceSchedulCriteria example);

    int deleteByExample(TbManpowerAttendanceSchedulCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerAttendanceSchedul record);

    int insertSelective(TbManpowerAttendanceSchedul record);

    List<TbManpowerAttendanceSchedul> selectByExample(TbManpowerAttendanceSchedulCriteria example);

    TbManpowerAttendanceSchedul selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerAttendanceSchedul record, @Param("example") TbManpowerAttendanceSchedulCriteria example);

    int updateByExample(@Param("record") TbManpowerAttendanceSchedul record, @Param("example") TbManpowerAttendanceSchedulCriteria example);

    int updateByPrimaryKeySelective(TbManpowerAttendanceSchedul record);

    int updateByPrimaryKey(TbManpowerAttendanceSchedul record);
}
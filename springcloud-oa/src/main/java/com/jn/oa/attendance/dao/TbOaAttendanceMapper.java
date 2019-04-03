package com.jn.oa.attendance.dao;

import com.jn.oa.attendance.entity.TbOaAttendance;
import com.jn.oa.attendance.entity.TbOaAttendanceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaAttendanceMapper {
    long countByExample(TbOaAttendanceCriteria example);

    int deleteByExample(TbOaAttendanceCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaAttendance record);

    int insertSelective(TbOaAttendance record);

    List<TbOaAttendance> selectByExample(TbOaAttendanceCriteria example);

    TbOaAttendance selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaAttendance record, @Param("example") TbOaAttendanceCriteria example);

    int updateByExample(@Param("record") TbOaAttendance record, @Param("example") TbOaAttendanceCriteria example);

    int updateByPrimaryKeySelective(TbOaAttendance record);

    int updateByPrimaryKey(TbOaAttendance record);
}
package com.jn.oa.meeting.dao;

import com.jn.oa.meeting.entity.TbOaMeeting;
import com.jn.oa.meeting.entity.TbOaMeetingCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaMeetingMapper {
    long countByExample(TbOaMeetingCriteria example);

    int deleteByExample(TbOaMeetingCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaMeeting record);

    int insertSelective(TbOaMeeting record);

    List<TbOaMeeting> selectByExample(TbOaMeetingCriteria example);

    TbOaMeeting selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaMeeting record, @Param("example") TbOaMeetingCriteria example);

    int updateByExample(@Param("record") TbOaMeeting record, @Param("example") TbOaMeetingCriteria example);

    int updateByPrimaryKeySelective(TbOaMeeting record);

    int updateByPrimaryKey(TbOaMeeting record);
}
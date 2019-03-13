package com.jn.oa.meeting.dao;

import com.jn.oa.meeting.entity.TbOaMeetingParticipants;
import com.jn.oa.meeting.entity.TbOaMeetingParticipantsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaMeetingParticipantsMapper {
    long countByExample(TbOaMeetingParticipantsCriteria example);

    int deleteByExample(TbOaMeetingParticipantsCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaMeetingParticipants record);

    int insertSelective(TbOaMeetingParticipants record);

    List<TbOaMeetingParticipants> selectByExample(TbOaMeetingParticipantsCriteria example);

    TbOaMeetingParticipants selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaMeetingParticipants record, @Param("example") TbOaMeetingParticipantsCriteria example);

    int updateByExample(@Param("record") TbOaMeetingParticipants record, @Param("example") TbOaMeetingParticipantsCriteria example);

    int updateByPrimaryKeySelective(TbOaMeetingParticipants record);

    int updateByPrimaryKey(TbOaMeetingParticipants record);
}
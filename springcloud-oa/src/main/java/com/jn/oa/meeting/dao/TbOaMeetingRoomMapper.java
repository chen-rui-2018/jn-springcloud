package com.jn.oa.meeting.dao;

import com.jn.oa.meeting.entity.TbOaMeetingRoom;
import com.jn.oa.meeting.entity.TbOaMeetingRoomCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaMeetingRoomMapper {
    long countByExample(TbOaMeetingRoomCriteria example);

    int deleteByExample(TbOaMeetingRoomCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaMeetingRoom record);

    int insertSelective(TbOaMeetingRoom record);

    List<TbOaMeetingRoom> selectByExample(TbOaMeetingRoomCriteria example);

    TbOaMeetingRoom selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaMeetingRoom record, @Param("example") TbOaMeetingRoomCriteria example);

    int updateByExample(@Param("record") TbOaMeetingRoom record, @Param("example") TbOaMeetingRoomCriteria example);

    int updateByPrimaryKeySelective(TbOaMeetingRoom record);

    int updateByPrimaryKey(TbOaMeetingRoom record);
}
package com.jn.oa.meeting.dao;

import com.jn.oa.meeting.entity.TbOaMeetingRoomPhoto;
import com.jn.oa.meeting.entity.TbOaMeetingRoomPhotoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaMeetingRoomPhotoMapper {
    long countByExample(TbOaMeetingRoomPhotoCriteria example);

    int deleteByExample(TbOaMeetingRoomPhotoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaMeetingRoomPhoto record);

    int insertSelective(TbOaMeetingRoomPhoto record);

    List<TbOaMeetingRoomPhoto> selectByExample(TbOaMeetingRoomPhotoCriteria example);

    TbOaMeetingRoomPhoto selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaMeetingRoomPhoto record, @Param("example") TbOaMeetingRoomPhotoCriteria example);

    int updateByExample(@Param("record") TbOaMeetingRoomPhoto record, @Param("example") TbOaMeetingRoomPhotoCriteria example);

    int updateByPrimaryKeySelective(TbOaMeetingRoomPhoto record);

    int updateByPrimaryKey(TbOaMeetingRoomPhoto record);
}
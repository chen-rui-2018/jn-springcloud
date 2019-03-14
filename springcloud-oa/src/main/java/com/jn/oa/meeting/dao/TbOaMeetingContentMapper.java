package com.jn.oa.meeting.dao;

import com.jn.oa.meeting.entity.TbOaMeetingContent;
import com.jn.oa.meeting.entity.TbOaMeetingContentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaMeetingContentMapper {
    long countByExample(TbOaMeetingContentCriteria example);

    int deleteByExample(TbOaMeetingContentCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaMeetingContent record);

    int insertSelective(TbOaMeetingContent record);

    List<TbOaMeetingContent> selectByExampleWithBLOBs(TbOaMeetingContentCriteria example);

    List<TbOaMeetingContent> selectByExample(TbOaMeetingContentCriteria example);

    TbOaMeetingContent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaMeetingContent record, @Param("example") TbOaMeetingContentCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbOaMeetingContent record, @Param("example") TbOaMeetingContentCriteria example);

    int updateByExample(@Param("record") TbOaMeetingContent record, @Param("example") TbOaMeetingContentCriteria example);

    int updateByPrimaryKeySelective(TbOaMeetingContent record);

    int updateByPrimaryKeyWithBLOBs(TbOaMeetingContent record);

    int updateByPrimaryKey(TbOaMeetingContent record);
}
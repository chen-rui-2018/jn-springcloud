package com.jn.park.gamtopic.dao;

import com.jn.park.gamtopic.entity.TbGamTopic;
import com.jn.park.gamtopic.entity.TbGamTopicCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGamTopicMapper {
    long countByExample(TbGamTopicCriteria example);

    int deleteByExample(TbGamTopicCriteria example);

    int deleteByPrimaryKey(String topicId);

    int insert(TbGamTopic record);

    int insertSelective(TbGamTopic record);

    List<TbGamTopic> selectByExample(TbGamTopicCriteria example);

    TbGamTopic selectByPrimaryKey(String topicId);

    int updateByExampleSelective(@Param("record") TbGamTopic record, @Param("example") TbGamTopicCriteria example);

    int updateByExample(@Param("record") TbGamTopic record, @Param("example") TbGamTopicCriteria example);

    int updateByPrimaryKeySelective(TbGamTopic record);

    int updateByPrimaryKey(TbGamTopic record);
}
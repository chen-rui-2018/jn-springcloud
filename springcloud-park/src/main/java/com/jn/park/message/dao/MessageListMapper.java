package com.jn.park.message.dao;

import com.jn.park.message.entity.MessageList;
import com.jn.park.message.entity.MessageListCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageListMapper {
    long countByExample(MessageListCriteria example);

    int deleteByExample(MessageListCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageList record);

    int insertSelective(MessageList record);

    List<MessageList> selectByExampleWithBLOBs(MessageListCriteria example);

    List<MessageList> selectByExample(MessageListCriteria example);

    MessageList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageList record, @Param("example") MessageListCriteria example);

    int updateByExampleWithBLOBs(@Param("record") MessageList record, @Param("example") MessageListCriteria example);

    int updateByExample(@Param("record") MessageList record, @Param("example") MessageListCriteria example);

    int updateByPrimaryKeySelective(MessageList record);

    int updateByPrimaryKeyWithBLOBs(MessageList record);

    int updateByPrimaryKey(MessageList record);
}
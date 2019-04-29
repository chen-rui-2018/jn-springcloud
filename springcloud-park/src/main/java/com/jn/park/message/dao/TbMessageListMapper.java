package com.jn.park.message.dao;

import com.jn.park.message.entity.TbMessageList;
import com.jn.park.message.entity.TbMessageListCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMessageListMapper {
    long countByExample(TbMessageListCriteria example);

    int deleteByExample(TbMessageListCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbMessageList record);

    int insertSelective(TbMessageList record);

    List<TbMessageList> selectByExampleWithBLOBs(TbMessageListCriteria example);

    List<TbMessageList> selectByExample(TbMessageListCriteria example);

    TbMessageList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbMessageList record, @Param("example") TbMessageListCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbMessageList record, @Param("example") TbMessageListCriteria example);

    int updateByExample(@Param("record") TbMessageList record, @Param("example") TbMessageListCriteria example);

    int updateByPrimaryKeySelective(TbMessageList record);

    int updateByPrimaryKeyWithBLOBs(TbMessageList record);

    int updateByPrimaryKey(TbMessageList record);
}
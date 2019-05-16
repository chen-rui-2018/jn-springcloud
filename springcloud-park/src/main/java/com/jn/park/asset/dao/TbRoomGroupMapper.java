package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbRoomGroup;
import com.jn.park.asset.entity.TbRoomGroupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRoomGroupMapper {
    long countByExample(TbRoomGroupCriteria example);

    int deleteByExample(TbRoomGroupCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbRoomGroup record);

    int insertSelective(TbRoomGroup record);

    List<TbRoomGroup> selectByExample(TbRoomGroupCriteria example);

    TbRoomGroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbRoomGroup record, @Param("example") TbRoomGroupCriteria example);

    int updateByExample(@Param("record") TbRoomGroup record, @Param("example") TbRoomGroupCriteria example);

    int updateByPrimaryKeySelective(TbRoomGroup record);

    int updateByPrimaryKey(TbRoomGroup record);
}
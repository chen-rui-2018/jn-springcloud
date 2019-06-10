package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbRoomOrdersBill;
import com.jn.park.asset.entity.TbRoomOrdersBillCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRoomOrdersBillMapper {
    long countByExample(TbRoomOrdersBillCriteria example);

    int deleteByExample(TbRoomOrdersBillCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbRoomOrdersBill record);

    int insertSelective(TbRoomOrdersBill record);

    List<TbRoomOrdersBill> selectByExample(TbRoomOrdersBillCriteria example);

    TbRoomOrdersBill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbRoomOrdersBill record, @Param("example") TbRoomOrdersBillCriteria example);

    int updateByExample(@Param("record") TbRoomOrdersBill record, @Param("example") TbRoomOrdersBillCriteria example);

    int updateByPrimaryKeySelective(TbRoomOrdersBill record);

    int updateByPrimaryKey(TbRoomOrdersBill record);
}
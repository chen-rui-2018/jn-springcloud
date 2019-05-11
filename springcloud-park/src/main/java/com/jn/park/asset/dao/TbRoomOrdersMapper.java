package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbRoomOrders;
import com.jn.park.asset.entity.TbRoomOrdersCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRoomOrdersMapper {
    long countByExample(TbRoomOrdersCriteria example);

    int deleteByExample(TbRoomOrdersCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbRoomOrders record);

    int insertSelective(TbRoomOrders record);

    List<TbRoomOrders> selectByExample(TbRoomOrdersCriteria example);

    TbRoomOrders selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbRoomOrders record, @Param("example") TbRoomOrdersCriteria example);

    int updateByExample(@Param("record") TbRoomOrders record, @Param("example") TbRoomOrdersCriteria example);

    int updateByPrimaryKeySelective(TbRoomOrders record);

    int updateByPrimaryKey(TbRoomOrders record);
}
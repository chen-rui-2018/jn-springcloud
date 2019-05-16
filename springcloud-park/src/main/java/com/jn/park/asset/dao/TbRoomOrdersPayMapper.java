package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbRoomOrdersPay;
import com.jn.park.asset.entity.TbRoomOrdersPayCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRoomOrdersPayMapper {
    long countByExample(TbRoomOrdersPayCriteria example);

    int deleteByExample(TbRoomOrdersPayCriteria example);

    int deleteByPrimaryKey(String payId);

    int insert(TbRoomOrdersPay record);

    int insertSelective(TbRoomOrdersPay record);

    List<TbRoomOrdersPay> selectByExample(TbRoomOrdersPayCriteria example);

    TbRoomOrdersPay selectByPrimaryKey(String payId);

    int updateByExampleSelective(@Param("record") TbRoomOrdersPay record, @Param("example") TbRoomOrdersPayCriteria example);

    int updateByExample(@Param("record") TbRoomOrdersPay record, @Param("example") TbRoomOrdersPayCriteria example);

    int updateByPrimaryKeySelective(TbRoomOrdersPay record);

    int updateByPrimaryKey(TbRoomOrdersPay record);
}
package com.jn.park.parking.dao;

import com.jn.park.parking.entity.TbParkingSpace;
import com.jn.park.parking.entity.TbParkingSpaceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParkingSpaceMapper {
    long countByExample(TbParkingSpaceCriteria example);

    int deleteByExample(TbParkingSpaceCriteria example);

    int deleteByPrimaryKey(String spaceId);

    int insert(TbParkingSpace record);

    int insertSelective(TbParkingSpace record);

    List<TbParkingSpace> selectByExample(TbParkingSpaceCriteria example);

    TbParkingSpace selectByPrimaryKey(String spaceId);

    int updateByExampleSelective(@Param("record") TbParkingSpace record, @Param("example") TbParkingSpaceCriteria example);

    int updateByExample(@Param("record") TbParkingSpace record, @Param("example") TbParkingSpaceCriteria example);

    int updateByPrimaryKeySelective(TbParkingSpace record);

    int updateByPrimaryKey(TbParkingSpace record);
}
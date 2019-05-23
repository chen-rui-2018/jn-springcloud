package com.jn.park.parking.dao;

import com.jn.park.parking.entity.TbParkingSpaceRental;
import com.jn.park.parking.entity.TbParkingSpaceRentalCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParkingSpaceRentalMapper {
    long countByExample(TbParkingSpaceRentalCriteria example);

    int deleteByExample(TbParkingSpaceRentalCriteria example);

    int deleteByPrimaryKey(String rentId);

    int insert(TbParkingSpaceRental record);

    int insertSelective(TbParkingSpaceRental record);

    List<TbParkingSpaceRental> selectByExample(TbParkingSpaceRentalCriteria example);

    TbParkingSpaceRental selectByPrimaryKey(String rentId);

    int updateByExampleSelective(@Param("record") TbParkingSpaceRental record, @Param("example") TbParkingSpaceRentalCriteria example);

    int updateByExample(@Param("record") TbParkingSpaceRental record, @Param("example") TbParkingSpaceRentalCriteria example);

    int updateByPrimaryKeySelective(TbParkingSpaceRental record);

    int updateByPrimaryKey(TbParkingSpaceRental record);
}
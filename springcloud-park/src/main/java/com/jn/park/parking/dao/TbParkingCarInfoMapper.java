package com.jn.park.parking.dao;

import com.jn.park.parking.entity.TbParkingCarInfo;
import com.jn.park.parking.entity.TbParkingCarInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParkingCarInfoMapper {
    long countByExample(TbParkingCarInfoCriteria example);

    int deleteByExample(TbParkingCarInfoCriteria example);

    int deleteByPrimaryKey(String carId);

    int insert(TbParkingCarInfo record);

    int insertSelective(TbParkingCarInfo record);

    List<TbParkingCarInfo> selectByExample(TbParkingCarInfoCriteria example);

    TbParkingCarInfo selectByPrimaryKey(String carId);

    int updateByExampleSelective(@Param("record") TbParkingCarInfo record, @Param("example") TbParkingCarInfoCriteria example);

    int updateByExample(@Param("record") TbParkingCarInfo record, @Param("example") TbParkingCarInfoCriteria example);

    int updateByPrimaryKeySelective(TbParkingCarInfo record);

    int updateByPrimaryKey(TbParkingCarInfo record);
}
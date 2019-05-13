package com.jn.park.parking.dao;

import com.jn.park.parking.entity.TbParkingArea;
import com.jn.park.parking.entity.TbParkingAreaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParkingAreaMapper {
    long countByExample(TbParkingAreaCriteria example);

    int deleteByExample(TbParkingAreaCriteria example);

    int deleteByPrimaryKey(String areaId);

    int insert(TbParkingArea record);

    int insertSelective(TbParkingArea record);

    List<TbParkingArea> selectByExample(TbParkingAreaCriteria example);

    TbParkingArea selectByPrimaryKey(String areaId);

    int updateByExampleSelective(@Param("record") TbParkingArea record, @Param("example") TbParkingAreaCriteria example);

    int updateByExample(@Param("record") TbParkingArea record, @Param("example") TbParkingAreaCriteria example);

    int updateByPrimaryKeySelective(TbParkingArea record);

    int updateByPrimaryKey(TbParkingArea record);
}
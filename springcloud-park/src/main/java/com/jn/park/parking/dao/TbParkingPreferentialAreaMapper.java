package com.jn.park.parking.dao;

import com.jn.park.parking.entity.TbParkingPreferentialArea;
import com.jn.park.parking.entity.TbParkingPreferentialAreaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParkingPreferentialAreaMapper {
    long countByExample(TbParkingPreferentialAreaCriteria example);

    int deleteByExample(TbParkingPreferentialAreaCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbParkingPreferentialArea record);

    int insertSelective(TbParkingPreferentialArea record);

    List<TbParkingPreferentialArea> selectByExample(TbParkingPreferentialAreaCriteria example);

    TbParkingPreferentialArea selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbParkingPreferentialArea record, @Param("example") TbParkingPreferentialAreaCriteria example);

    int updateByExample(@Param("record") TbParkingPreferentialArea record, @Param("example") TbParkingPreferentialAreaCriteria example);

    int updateByPrimaryKeySelective(TbParkingPreferentialArea record);

    int updateByPrimaryKey(TbParkingPreferentialArea record);
}
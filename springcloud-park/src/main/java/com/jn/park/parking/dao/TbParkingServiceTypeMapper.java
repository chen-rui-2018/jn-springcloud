package com.jn.park.parking.dao;

import com.jn.park.parking.entity.TbParkingServiceType;
import com.jn.park.parking.entity.TbParkingServiceTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParkingServiceTypeMapper {
    long countByExample(TbParkingServiceTypeCriteria example);

    int deleteByExample(TbParkingServiceTypeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbParkingServiceType record);

    int insertSelective(TbParkingServiceType record);

    List<TbParkingServiceType> selectByExample(TbParkingServiceTypeCriteria example);

    TbParkingServiceType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbParkingServiceType record, @Param("example") TbParkingServiceTypeCriteria example);

    int updateByExample(@Param("record") TbParkingServiceType record, @Param("example") TbParkingServiceTypeCriteria example);

    int updateByPrimaryKeySelective(TbParkingServiceType record);

    int updateByPrimaryKey(TbParkingServiceType record);
}
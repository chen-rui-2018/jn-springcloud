package com.jn.park.parking.dao;

import com.jn.park.parking.entity.TbParkingService;
import com.jn.park.parking.entity.TbParkingServiceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParkingServiceMapper {
    long countByExample(TbParkingServiceCriteria example);

    int deleteByExample(TbParkingServiceCriteria example);

    int insert(TbParkingService record);

    int insertSelective(TbParkingService record);

    List<TbParkingService> selectByExample(TbParkingServiceCriteria example);

    int updateByExampleSelective(@Param("record") TbParkingService record, @Param("example") TbParkingServiceCriteria example);

    int updateByExample(@Param("record") TbParkingService record, @Param("example") TbParkingServiceCriteria example);
}
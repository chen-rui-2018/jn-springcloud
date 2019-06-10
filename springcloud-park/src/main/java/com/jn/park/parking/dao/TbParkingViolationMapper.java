package com.jn.park.parking.dao;

import com.jn.park.parking.entity.TbParkingViolation;
import com.jn.park.parking.entity.TbParkingViolationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParkingViolationMapper {
    long countByExample(TbParkingViolationCriteria example);

    int deleteByExample(TbParkingViolationCriteria example);

    int deleteByPrimaryKey(String reportId);

    int insert(TbParkingViolation record);

    int insertSelective(TbParkingViolation record);

    List<TbParkingViolation> selectByExample(TbParkingViolationCriteria example);

    TbParkingViolation selectByPrimaryKey(String reportId);

    int updateByExampleSelective(@Param("record") TbParkingViolation record, @Param("example") TbParkingViolationCriteria example);

    int updateByExample(@Param("record") TbParkingViolation record, @Param("example") TbParkingViolationCriteria example);

    int updateByPrimaryKeySelective(TbParkingViolation record);

    int updateByPrimaryKey(TbParkingViolation record);
}
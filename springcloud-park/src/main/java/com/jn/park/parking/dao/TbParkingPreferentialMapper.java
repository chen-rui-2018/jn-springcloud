package com.jn.park.parking.dao;

import com.jn.park.parking.entity.TbParkingPreferential;
import com.jn.park.parking.entity.TbParkingPreferentialCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParkingPreferentialMapper {
    long countByExample(TbParkingPreferentialCriteria example);

    int deleteByExample(TbParkingPreferentialCriteria example);

    int deleteByPrimaryKey(String policyId);

    int insert(TbParkingPreferential record);

    int insertSelective(TbParkingPreferential record);

    List<TbParkingPreferential> selectByExample(TbParkingPreferentialCriteria example);

    TbParkingPreferential selectByPrimaryKey(String policyId);

    int updateByExampleSelective(@Param("record") TbParkingPreferential record, @Param("example") TbParkingPreferentialCriteria example);

    int updateByExample(@Param("record") TbParkingPreferential record, @Param("example") TbParkingPreferentialCriteria example);

    int updateByPrimaryKeySelective(TbParkingPreferential record);

    int updateByPrimaryKey(TbParkingPreferential record);
}
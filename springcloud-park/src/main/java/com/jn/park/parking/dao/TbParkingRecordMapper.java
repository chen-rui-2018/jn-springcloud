package com.jn.park.parking.dao;

import com.jn.park.parking.entity.TbParkingRecord;
import com.jn.park.parking.entity.TbParkingRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParkingRecordMapper {
    long countByExample(TbParkingRecordCriteria example);

    int deleteByExample(TbParkingRecordCriteria example);

    int deleteByPrimaryKey(String parkingId);

    int insert(TbParkingRecord record);

    int insertSelective(TbParkingRecord record);

    List<TbParkingRecord> selectByExample(TbParkingRecordCriteria example);

    TbParkingRecord selectByPrimaryKey(String parkingId);

    int updateByExampleSelective(@Param("record") TbParkingRecord record, @Param("example") TbParkingRecordCriteria example);

    int updateByExample(@Param("record") TbParkingRecord record, @Param("example") TbParkingRecordCriteria example);

    int updateByPrimaryKeySelective(TbParkingRecord record);

    int updateByPrimaryKey(TbParkingRecord record);
}
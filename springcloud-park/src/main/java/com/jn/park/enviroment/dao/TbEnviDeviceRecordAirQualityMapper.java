package com.jn.park.enviroment.dao;

import com.jn.park.enviroment.entity.TbEnviDeviceRecordAirQuality;
import com.jn.park.enviroment.entity.TbEnviDeviceRecordAirQualityCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEnviDeviceRecordAirQualityMapper {
    long countByExample(TbEnviDeviceRecordAirQualityCriteria example);

    int deleteByExample(TbEnviDeviceRecordAirQualityCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbEnviDeviceRecordAirQuality record);

    int insertSelective(TbEnviDeviceRecordAirQuality record);

    List<TbEnviDeviceRecordAirQuality> selectByExample(TbEnviDeviceRecordAirQualityCriteria example);

    TbEnviDeviceRecordAirQuality selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbEnviDeviceRecordAirQuality record, @Param("example") TbEnviDeviceRecordAirQualityCriteria example);

    int updateByExample(@Param("record") TbEnviDeviceRecordAirQuality record, @Param("example") TbEnviDeviceRecordAirQualityCriteria example);

    int updateByPrimaryKeySelective(TbEnviDeviceRecordAirQuality record);

    int updateByPrimaryKey(TbEnviDeviceRecordAirQuality record);
}
package com.jn.park.enviroment.dao;

import com.jn.park.enviroment.entity.TbEnviDeviceRecordAvg;
import com.jn.park.enviroment.entity.TbEnviDeviceRecordAvgCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEnviDeviceRecordAvgMapper {
    long countByExample(TbEnviDeviceRecordAvgCriteria example);

    int deleteByExample(TbEnviDeviceRecordAvgCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbEnviDeviceRecordAvg record);

    int insertSelective(TbEnviDeviceRecordAvg record);

    List<TbEnviDeviceRecordAvg> selectByExample(TbEnviDeviceRecordAvgCriteria example);

    TbEnviDeviceRecordAvg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbEnviDeviceRecordAvg record, @Param("example") TbEnviDeviceRecordAvgCriteria example);

    int updateByExample(@Param("record") TbEnviDeviceRecordAvg record, @Param("example") TbEnviDeviceRecordAvgCriteria example);

    int updateByPrimaryKeySelective(TbEnviDeviceRecordAvg record);

    int updateByPrimaryKey(TbEnviDeviceRecordAvg record);
}
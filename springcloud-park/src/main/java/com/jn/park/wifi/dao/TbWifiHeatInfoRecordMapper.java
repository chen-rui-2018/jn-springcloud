package com.jn.park.wifi.dao;

import com.jn.park.wifi.entity.TbWifiHeatInfoRecord;
import com.jn.park.wifi.entity.TbWifiHeatInfoRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbWifiHeatInfoRecordMapper {
    long countByExample(TbWifiHeatInfoRecordCriteria example);

    int deleteByExample(TbWifiHeatInfoRecordCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbWifiHeatInfoRecord record);

    int insertSelective(TbWifiHeatInfoRecord record);

    List<TbWifiHeatInfoRecord> selectByExample(TbWifiHeatInfoRecordCriteria example);

    TbWifiHeatInfoRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbWifiHeatInfoRecord record, @Param("example") TbWifiHeatInfoRecordCriteria example);

    int updateByExample(@Param("record") TbWifiHeatInfoRecord record, @Param("example") TbWifiHeatInfoRecordCriteria example);

    int updateByPrimaryKeySelective(TbWifiHeatInfoRecord record);

    int updateByPrimaryKey(TbWifiHeatInfoRecord record);
}
package com.jn.park.wifi.dao;

import com.jn.park.wifi.entity.TbWifiTowerHeatInfo;
import com.jn.park.wifi.entity.TbWifiTowerHeatInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbWifiTowerHeatInfoMapper {
    long countByExample(TbWifiTowerHeatInfoCriteria example);

    int deleteByExample(TbWifiTowerHeatInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbWifiTowerHeatInfo record);

    int insertSelective(TbWifiTowerHeatInfo record);

    List<TbWifiTowerHeatInfo> selectByExample(TbWifiTowerHeatInfoCriteria example);

    TbWifiTowerHeatInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbWifiTowerHeatInfo record, @Param("example") TbWifiTowerHeatInfoCriteria example);

    int updateByExample(@Param("record") TbWifiTowerHeatInfo record, @Param("example") TbWifiTowerHeatInfoCriteria example);

    int updateByPrimaryKeySelective(TbWifiTowerHeatInfo record);

    int updateByPrimaryKey(TbWifiTowerHeatInfo record);
}
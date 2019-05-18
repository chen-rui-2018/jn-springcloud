package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricMeterInfo;
import com.jn.park.electricmeter.entity.TbElectricMeterInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricMeterInfoMapper {
    long countByExample(TbElectricMeterInfoCriteria example);

    int deleteByExample(TbElectricMeterInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricMeterInfo record);

    int insertSelective(TbElectricMeterInfo record);

    List<TbElectricMeterInfo> selectByExample(TbElectricMeterInfoCriteria example);

    TbElectricMeterInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricMeterInfo record, @Param("example") TbElectricMeterInfoCriteria example);

    int updateByExample(@Param("record") TbElectricMeterInfo record, @Param("example") TbElectricMeterInfoCriteria example);

    int updateByPrimaryKeySelective(TbElectricMeterInfo record);

    int updateByPrimaryKey(TbElectricMeterInfo record);
}
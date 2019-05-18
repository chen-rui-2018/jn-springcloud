package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricReading;
import com.jn.park.electricmeter.entity.TbElectricReadingCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricReadingMapper {
    long countByExample(TbElectricReadingCriteria example);

    int deleteByExample(TbElectricReadingCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricReading record);

    int insertSelective(TbElectricReading record);

    List<TbElectricReading> selectByExample(TbElectricReadingCriteria example);

    TbElectricReading selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricReading record, @Param("example") TbElectricReadingCriteria example);

    int updateByExample(@Param("record") TbElectricReading record, @Param("example") TbElectricReadingCriteria example);

    int updateByPrimaryKeySelective(TbElectricReading record);

    int updateByPrimaryKey(TbElectricReading record);
}
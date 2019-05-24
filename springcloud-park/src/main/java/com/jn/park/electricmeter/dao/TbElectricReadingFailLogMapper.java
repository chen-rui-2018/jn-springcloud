package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricReadingFailLog;
import com.jn.park.electricmeter.entity.TbElectricReadingFailLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricReadingFailLogMapper {
    long countByExample(TbElectricReadingFailLogCriteria example);

    int deleteByExample(TbElectricReadingFailLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricReadingFailLog record);

    int insertSelective(TbElectricReadingFailLog record);

    List<TbElectricReadingFailLog> selectByExample(TbElectricReadingFailLogCriteria example);

    TbElectricReadingFailLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricReadingFailLog record, @Param("example") TbElectricReadingFailLogCriteria example);

    int updateByExample(@Param("record") TbElectricReadingFailLog record, @Param("example") TbElectricReadingFailLogCriteria example);

    int updateByPrimaryKeySelective(TbElectricReadingFailLog record);

    int updateByPrimaryKey(TbElectricReadingFailLog record);
}
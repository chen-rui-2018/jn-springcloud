package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricErrorLog;
import com.jn.park.electricmeter.entity.TbElectricErrorLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricErrorLogMapper {
    long countByExample(TbElectricErrorLogCriteria example);

    int deleteByExample(TbElectricErrorLogCriteria example);

    int insert(TbElectricErrorLog record);

    int insertSelective(TbElectricErrorLog record);

    List<TbElectricErrorLog> selectByExample(TbElectricErrorLogCriteria example);

    int updateByExampleSelective(@Param("record") TbElectricErrorLog record, @Param("example") TbElectricErrorLogCriteria example);

    int updateByExample(@Param("record") TbElectricErrorLog record, @Param("example") TbElectricErrorLogCriteria example);
}
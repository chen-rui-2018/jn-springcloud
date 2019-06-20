package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricReadingSource;
import com.jn.park.electricmeter.entity.TbElectricReadingSourceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricReadingSourceMapper {
    long countByExample(TbElectricReadingSourceCriteria example);

    int deleteByExample(TbElectricReadingSourceCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricReadingSource record);

    int insertSelective(TbElectricReadingSource record);

    List<TbElectricReadingSource> selectByExample(TbElectricReadingSourceCriteria example);

    TbElectricReadingSource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricReadingSource record, @Param("example") TbElectricReadingSourceCriteria example);

    int updateByExample(@Param("record") TbElectricReadingSource record, @Param("example") TbElectricReadingSourceCriteria example);

    int updateByPrimaryKeySelective(TbElectricReadingSource record);

    int updateByPrimaryKey(TbElectricReadingSource record);
}
package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricWarningRecord;
import com.jn.park.electricmeter.entity.TbElectricWarningRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricWarningRecordMapper {
    long countByExample(TbElectricWarningRecordCriteria example);

    int deleteByExample(TbElectricWarningRecordCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricWarningRecord record);

    int insertSelective(TbElectricWarningRecord record);

    List<TbElectricWarningRecord> selectByExample(TbElectricWarningRecordCriteria example);

    TbElectricWarningRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricWarningRecord record, @Param("example") TbElectricWarningRecordCriteria example);

    int updateByExample(@Param("record") TbElectricWarningRecord record, @Param("example") TbElectricWarningRecordCriteria example);

    int updateByPrimaryKeySelective(TbElectricWarningRecord record);

    int updateByPrimaryKey(TbElectricWarningRecord record);
}
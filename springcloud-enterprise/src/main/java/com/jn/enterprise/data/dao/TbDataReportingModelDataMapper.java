package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingModelData;
import com.jn.enterprise.data.entity.TbDataReportingModelDataCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingModelDataMapper {
    long countByExample(TbDataReportingModelDataCriteria example);

    int deleteByExample(TbDataReportingModelDataCriteria example);

    int deleteByPrimaryKey(String fallInFormId);

    int insert(TbDataReportingModelData record);

    int insertSelective(TbDataReportingModelData record);

    List<TbDataReportingModelData> selectByExample(TbDataReportingModelDataCriteria example);

    TbDataReportingModelData selectByPrimaryKey(String fallInFormId);

    int updateByExampleSelective(@Param("record") TbDataReportingModelData record, @Param("example") TbDataReportingModelDataCriteria example);

    int updateByExample(@Param("record") TbDataReportingModelData record, @Param("example") TbDataReportingModelDataCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingModelData record);

    int updateByPrimaryKey(TbDataReportingModelData record);
}
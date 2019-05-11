package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingModel;
import com.jn.enterprise.data.entity.TbDataReportingModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingModelMapper {
    long countByExample(TbDataReportingModelCriteria example);

    int deleteByExample(TbDataReportingModelCriteria example);

    int deleteByPrimaryKey(String modelId);

    int insert(TbDataReportingModel record);

    int insertSelective(TbDataReportingModel record);

    List<TbDataReportingModel> selectByExample(TbDataReportingModelCriteria example);

    TbDataReportingModel selectByPrimaryKey(String modelId);

    int updateByExampleSelective(@Param("record") TbDataReportingModel record, @Param("example") TbDataReportingModelCriteria example);

    int updateByExample(@Param("record") TbDataReportingModel record, @Param("example") TbDataReportingModelCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingModel record);

    int updateByPrimaryKey(TbDataReportingModel record);
}
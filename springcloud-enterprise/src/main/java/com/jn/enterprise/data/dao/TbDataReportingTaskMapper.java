package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingTask;
import com.jn.enterprise.data.entity.TbDataReportingTaskCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingTaskMapper {
    long countByExample(TbDataReportingTaskCriteria example);

    int deleteByExample(TbDataReportingTaskCriteria example);

    int deleteByPrimaryKey(String fillId);

    int insert(TbDataReportingTask record);

    int insertSelective(TbDataReportingTask record);

    List<TbDataReportingTask> selectByExample(TbDataReportingTaskCriteria example);

    TbDataReportingTask selectByPrimaryKey(String fillId);

    int updateByExampleSelective(@Param("record") TbDataReportingTask record, @Param("example") TbDataReportingTaskCriteria example);

    int updateByExample(@Param("record") TbDataReportingTask record, @Param("example") TbDataReportingTaskCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingTask record);

    int updateByPrimaryKey(TbDataReportingTask record);
}
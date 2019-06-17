package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingTaskData;
import com.jn.enterprise.data.entity.TbDataReportingTaskDataCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingTaskDataMapper {
    long countByExample(TbDataReportingTaskDataCriteria example);

    int deleteByExample(TbDataReportingTaskDataCriteria example);

    int deleteByPrimaryKey(String fallInFormId);

    int insert(TbDataReportingTaskData record);

    int insertSelective(TbDataReportingTaskData record);

    List<TbDataReportingTaskData> selectByExample(TbDataReportingTaskDataCriteria example);

    TbDataReportingTaskData selectByPrimaryKey(String fallInFormId);

    int updateByExampleSelective(@Param("record") TbDataReportingTaskData record, @Param("example") TbDataReportingTaskDataCriteria example);

    int updateByExample(@Param("record") TbDataReportingTaskData record, @Param("example") TbDataReportingTaskDataCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingTaskData record);

    int updateByPrimaryKey(TbDataReportingTaskData record);
}
package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingCreateTaskLog;
import com.jn.enterprise.data.entity.TbDataReportingCreateTaskLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingCreateTaskLogMapper {
    long countByExample(TbDataReportingCreateTaskLogCriteria example);

    int deleteByExample(TbDataReportingCreateTaskLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbDataReportingCreateTaskLog record);

    int insertSelective(TbDataReportingCreateTaskLog record);

    List<TbDataReportingCreateTaskLog> selectByExample(TbDataReportingCreateTaskLogCriteria example);

    TbDataReportingCreateTaskLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbDataReportingCreateTaskLog record, @Param("example") TbDataReportingCreateTaskLogCriteria example);

    int updateByExample(@Param("record") TbDataReportingCreateTaskLog record, @Param("example") TbDataReportingCreateTaskLogCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingCreateTaskLog record);

    int updateByPrimaryKey(TbDataReportingCreateTaskLog record);
}
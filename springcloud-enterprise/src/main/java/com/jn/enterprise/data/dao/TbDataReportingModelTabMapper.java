package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingModelTab;
import com.jn.enterprise.data.entity.TbDataReportingModelTabCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingModelTabMapper {
    long countByExample(TbDataReportingModelTabCriteria example);

    int deleteByExample(TbDataReportingModelTabCriteria example);

    int deleteByPrimaryKey(String tabId);

    int insert(TbDataReportingModelTab record);

    int insertSelective(TbDataReportingModelTab record);

    List<TbDataReportingModelTab> selectByExample(TbDataReportingModelTabCriteria example);

    TbDataReportingModelTab selectByPrimaryKey(String tabId);

    int updateByExampleSelective(@Param("record") TbDataReportingModelTab record, @Param("example") TbDataReportingModelTabCriteria example);

    int updateByExample(@Param("record") TbDataReportingModelTab record, @Param("example") TbDataReportingModelTabCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingModelTab record);

    int updateByPrimaryKey(TbDataReportingModelTab record);
}
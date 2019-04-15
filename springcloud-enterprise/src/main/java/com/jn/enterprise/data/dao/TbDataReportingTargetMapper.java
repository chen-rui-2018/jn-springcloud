package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingTarget;
import com.jn.enterprise.data.entity.TbDataReportingTargetCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingTargetMapper {
    long countByExample(TbDataReportingTargetCriteria example);

    int deleteByExample(TbDataReportingTargetCriteria example);

    int deleteByPrimaryKey(String targetId);

    int insert(TbDataReportingTarget record);

    int insertSelective(TbDataReportingTarget record);

    List<TbDataReportingTarget> selectByExample(TbDataReportingTargetCriteria example);

    TbDataReportingTarget selectByPrimaryKey(String targetId);

    int updateByExampleSelective(@Param("record") TbDataReportingTarget record, @Param("example") TbDataReportingTargetCriteria example);

    int updateByExample(@Param("record") TbDataReportingTarget record, @Param("example") TbDataReportingTargetCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingTarget record);

    int updateByPrimaryKey(TbDataReportingTarget record);
}
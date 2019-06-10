package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingTargetGroup;
import com.jn.enterprise.data.entity.TbDataReportingTargetGroupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingTargetGroupMapper {
    long countByExample(TbDataReportingTargetGroupCriteria example);

    int deleteByExample(TbDataReportingTargetGroupCriteria example);

    int deleteByPrimaryKey(String formId);

    int insert(TbDataReportingTargetGroup record);

    int insertSelective(TbDataReportingTargetGroup record);

    List<TbDataReportingTargetGroup> selectByExample(TbDataReportingTargetGroupCriteria example);

    TbDataReportingTargetGroup selectByPrimaryKey(String formId);

    int updateByExampleSelective(@Param("record") TbDataReportingTargetGroup record, @Param("example") TbDataReportingTargetGroupCriteria example);

    int updateByExample(@Param("record") TbDataReportingTargetGroup record, @Param("example") TbDataReportingTargetGroupCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingTargetGroup record);

    int updateByPrimaryKey(TbDataReportingTargetGroup record);
}
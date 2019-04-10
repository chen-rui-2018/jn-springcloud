package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingSnapshotTargetGroup;
import com.jn.enterprise.data.entity.TbDataReportingSnapshotTargetGroupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingSnapshotTargetGroupMapper {
    long countByExample(TbDataReportingSnapshotTargetGroupCriteria example);

    int deleteByExample(TbDataReportingSnapshotTargetGroupCriteria example);

    int insert(TbDataReportingSnapshotTargetGroup record);

    int insertSelective(TbDataReportingSnapshotTargetGroup record);

    List<TbDataReportingSnapshotTargetGroup> selectByExample(TbDataReportingSnapshotTargetGroupCriteria example);

    int updateByExampleSelective(@Param("record") TbDataReportingSnapshotTargetGroup record, @Param("example") TbDataReportingSnapshotTargetGroupCriteria example);

    int updateByExample(@Param("record") TbDataReportingSnapshotTargetGroup record, @Param("example") TbDataReportingSnapshotTargetGroupCriteria example);
}
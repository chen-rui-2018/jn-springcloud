package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingSnapshotTarget;
import com.jn.enterprise.data.entity.TbDataReportingSnapshotTargetCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingSnapshotTargetMapper {
    long countByExample(TbDataReportingSnapshotTargetCriteria example);

    int deleteByExample(TbDataReportingSnapshotTargetCriteria example);

    int insert(TbDataReportingSnapshotTarget record);

    int insertSelective(TbDataReportingSnapshotTarget record);

    List<TbDataReportingSnapshotTarget> selectByExample(TbDataReportingSnapshotTargetCriteria example);

    int updateByExampleSelective(@Param("record") TbDataReportingSnapshotTarget record, @Param("example") TbDataReportingSnapshotTargetCriteria example);

    int updateByExample(@Param("record") TbDataReportingSnapshotTarget record, @Param("example") TbDataReportingSnapshotTargetCriteria example);
}
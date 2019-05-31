package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingSnapshotModel;
import com.jn.enterprise.data.entity.TbDataReportingSnapshotModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingSnapshotModelMapper {
    long countByExample(TbDataReportingSnapshotModelCriteria example);

    int deleteByExample(TbDataReportingSnapshotModelCriteria example);

    int deleteByPrimaryKey(String taskBatch);

    int insert(TbDataReportingSnapshotModel record);

    int insertSelective(TbDataReportingSnapshotModel record);

    List<TbDataReportingSnapshotModel> selectByExample(TbDataReportingSnapshotModelCriteria example);

    TbDataReportingSnapshotModel selectByPrimaryKey(String taskBatch);

    int updateByExampleSelective(@Param("record") TbDataReportingSnapshotModel record, @Param("example") TbDataReportingSnapshotModelCriteria example);

    int updateByExample(@Param("record") TbDataReportingSnapshotModel record, @Param("example") TbDataReportingSnapshotModelCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingSnapshotModel record);

    int updateByPrimaryKey(TbDataReportingSnapshotModel record);
}
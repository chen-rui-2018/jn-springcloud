package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingSnapshotModelTab;
import com.jn.enterprise.data.entity.TbDataReportingSnapshotModelTabCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingSnapshotModelTabMapper {
    long countByExample(TbDataReportingSnapshotModelTabCriteria example);

    int deleteByExample(TbDataReportingSnapshotModelTabCriteria example);

    int insert(TbDataReportingSnapshotModelTab record);

    int insertSelective(TbDataReportingSnapshotModelTab record);

    List<TbDataReportingSnapshotModelTab> selectByExample(TbDataReportingSnapshotModelTabCriteria example);

    int updateByExampleSelective(@Param("record") TbDataReportingSnapshotModelTab record, @Param("example") TbDataReportingSnapshotModelTabCriteria example);

    int updateByExample(@Param("record") TbDataReportingSnapshotModelTab record, @Param("example") TbDataReportingSnapshotModelTabCriteria example);
}
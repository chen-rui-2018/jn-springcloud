package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingSnapshotModelStruct;
import com.jn.enterprise.data.entity.TbDataReportingSnapshotModelStructCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingSnapshotModelStructMapper {
    long countByExample(TbDataReportingSnapshotModelStructCriteria example);

    int deleteByExample(TbDataReportingSnapshotModelStructCriteria example);

    int insert(TbDataReportingSnapshotModelStruct record);

    int insertSelective(TbDataReportingSnapshotModelStruct record);

    List<TbDataReportingSnapshotModelStruct> selectByExample(TbDataReportingSnapshotModelStructCriteria example);

    int updateByExampleSelective(@Param("record") TbDataReportingSnapshotModelStruct record, @Param("example") TbDataReportingSnapshotModelStructCriteria example);

    int updateByExample(@Param("record") TbDataReportingSnapshotModelStruct record, @Param("example") TbDataReportingSnapshotModelStructCriteria example);
}
package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingGardenCheckAccess;
import com.jn.enterprise.data.entity.TbDataReportingGardenCheckAccessCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingGardenCheckAccessMapper {
    long countByExample(TbDataReportingGardenCheckAccessCriteria example);

    int deleteByExample(TbDataReportingGardenCheckAccessCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbDataReportingGardenCheckAccess record);

    int insertSelective(TbDataReportingGardenCheckAccess record);

    List<TbDataReportingGardenCheckAccess> selectByExample(TbDataReportingGardenCheckAccessCriteria example);

    TbDataReportingGardenCheckAccess selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbDataReportingGardenCheckAccess record, @Param("example") TbDataReportingGardenCheckAccessCriteria example);

    int updateByExample(@Param("record") TbDataReportingGardenCheckAccess record, @Param("example") TbDataReportingGardenCheckAccessCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingGardenCheckAccess record);

    int updateByPrimaryKey(TbDataReportingGardenCheckAccess record);
}
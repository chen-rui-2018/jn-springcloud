package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingGardenLinker;
import com.jn.enterprise.data.entity.TbDataReportingGardenLinkerCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingGardenLinkerMapper {
    long countByExample(TbDataReportingGardenLinkerCriteria example);

    int deleteByExample(TbDataReportingGardenLinkerCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbDataReportingGardenLinker record);

    int insertSelective(TbDataReportingGardenLinker record);

    List<TbDataReportingGardenLinker> selectByExample(TbDataReportingGardenLinkerCriteria example);

    TbDataReportingGardenLinker selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbDataReportingGardenLinker record, @Param("example") TbDataReportingGardenLinkerCriteria example);

    int updateByExample(@Param("record") TbDataReportingGardenLinker record, @Param("example") TbDataReportingGardenLinkerCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingGardenLinker record);

    int updateByPrimaryKey(TbDataReportingGardenLinker record);
}
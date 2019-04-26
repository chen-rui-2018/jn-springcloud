package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingGardenFiller;
import com.jn.enterprise.data.entity.TbDataReportingGardenFillerCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingGardenFillerMapper {
    long countByExample(TbDataReportingGardenFillerCriteria example);

    int deleteByExample(TbDataReportingGardenFillerCriteria example);

    int insert(TbDataReportingGardenFiller record);

    int insertSelective(TbDataReportingGardenFiller record);

    List<TbDataReportingGardenFiller> selectByExample(TbDataReportingGardenFillerCriteria example);

    int updateByExampleSelective(@Param("record") TbDataReportingGardenFiller record, @Param("example") TbDataReportingGardenFillerCriteria example);

    int updateByExample(@Param("record") TbDataReportingGardenFiller record, @Param("example") TbDataReportingGardenFillerCriteria example);
}
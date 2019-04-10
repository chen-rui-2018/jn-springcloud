package com.jn.enterprise.data.dao;

import com.jn.enterprise.data.entity.TbDataReportingGroupCompany;
import com.jn.enterprise.data.entity.TbDataReportingGroupCompanyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataReportingGroupCompanyMapper {
    long countByExample(TbDataReportingGroupCompanyCriteria example);

    int deleteByExample(TbDataReportingGroupCompanyCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbDataReportingGroupCompany record);

    int insertSelective(TbDataReportingGroupCompany record);

    List<TbDataReportingGroupCompany> selectByExample(TbDataReportingGroupCompanyCriteria example);

    TbDataReportingGroupCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbDataReportingGroupCompany record, @Param("example") TbDataReportingGroupCompanyCriteria example);

    int updateByExample(@Param("record") TbDataReportingGroupCompany record, @Param("example") TbDataReportingGroupCompanyCriteria example);

    int updateByPrimaryKeySelective(TbDataReportingGroupCompany record);

    int updateByPrimaryKey(TbDataReportingGroupCompany record);
}
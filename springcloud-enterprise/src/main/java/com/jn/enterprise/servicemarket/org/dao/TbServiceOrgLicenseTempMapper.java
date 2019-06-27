package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgLicenseTemp;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgLicenseTempCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceOrgLicenseTempMapper {
    long countByExample(TbServiceOrgLicenseTempCriteria example);

    int deleteByExample(TbServiceOrgLicenseTempCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceOrgLicenseTemp record);

    int insertSelective(TbServiceOrgLicenseTemp record);

    List<TbServiceOrgLicenseTemp> selectByExample(TbServiceOrgLicenseTempCriteria example);

    TbServiceOrgLicenseTemp selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceOrgLicenseTemp record, @Param("example") TbServiceOrgLicenseTempCriteria example);

    int updateByExample(@Param("record") TbServiceOrgLicenseTemp record, @Param("example") TbServiceOrgLicenseTempCriteria example);

    int updateByPrimaryKeySelective(TbServiceOrgLicenseTemp record);

    int updateByPrimaryKey(TbServiceOrgLicenseTemp record);
}
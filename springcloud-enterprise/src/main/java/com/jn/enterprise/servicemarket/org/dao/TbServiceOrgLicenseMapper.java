package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgLicense;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgLicenseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceOrgLicenseMapper {
    long countByExample(TbServiceOrgLicenseCriteria example);

    int deleteByExample(TbServiceOrgLicenseCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceOrgLicense record);

    int insertSelective(TbServiceOrgLicense record);

    List<TbServiceOrgLicense> selectByExample(TbServiceOrgLicenseCriteria example);

    TbServiceOrgLicense selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceOrgLicense record, @Param("example") TbServiceOrgLicenseCriteria example);

    int updateByExample(@Param("record") TbServiceOrgLicense record, @Param("example") TbServiceOrgLicenseCriteria example);

    int updateByPrimaryKeySelective(TbServiceOrgLicense record);

    int updateByPrimaryKey(TbServiceOrgLicense record);
}
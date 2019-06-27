package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgInfoTemp;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgInfoTempCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceOrgInfoTempMapper {
    long countByExample(TbServiceOrgInfoTempCriteria example);

    int deleteByExample(TbServiceOrgInfoTempCriteria example);

    int insert(TbServiceOrgInfoTemp record);

    int insertSelective(TbServiceOrgInfoTemp record);

    List<TbServiceOrgInfoTemp> selectByExample(TbServiceOrgInfoTempCriteria example);

    int updateByExampleSelective(@Param("record") TbServiceOrgInfoTemp record, @Param("example") TbServiceOrgInfoTempCriteria example);

    int updateByExample(@Param("record") TbServiceOrgInfoTemp record, @Param("example") TbServiceOrgInfoTempCriteria example);
}
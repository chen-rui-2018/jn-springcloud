package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgInfo;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceOrgInfoMapper {
    long countByExample(TbServiceOrgInfoCriteria example);

    int deleteByExample(TbServiceOrgInfoCriteria example);

    int deleteByPrimaryKey(String orgId);

    int insert(TbServiceOrgInfo record);

    int insertSelective(TbServiceOrgInfo record);

    List<TbServiceOrgInfo> selectByExample(TbServiceOrgInfoCriteria example);

    TbServiceOrgInfo selectByPrimaryKey(String orgId);

    int updateByExampleSelective(@Param("record") TbServiceOrgInfo record, @Param("example") TbServiceOrgInfoCriteria example);

    int updateByExample(@Param("record") TbServiceOrgInfo record, @Param("example") TbServiceOrgInfoCriteria example);

    int updateByPrimaryKeySelective(TbServiceOrgInfo record);

    int updateByPrimaryKey(TbServiceOrgInfo record);
}
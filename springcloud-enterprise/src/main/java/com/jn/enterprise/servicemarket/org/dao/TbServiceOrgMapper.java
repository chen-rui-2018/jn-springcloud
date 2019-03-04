package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrg;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceOrgMapper {
    long countByExample(TbServiceOrgCriteria example);

    int deleteByExample(TbServiceOrgCriteria example);

    int deleteByPrimaryKey(String orgId);

    int insert(TbServiceOrg record);

    int insertSelective(TbServiceOrg record);

    List<TbServiceOrg> selectByExample(TbServiceOrgCriteria example);

    TbServiceOrg selectByPrimaryKey(String orgId);

    int updateByExampleSelective(@Param("record") TbServiceOrg record, @Param("example") TbServiceOrgCriteria example);

    int updateByExample(@Param("record") TbServiceOrg record, @Param("example") TbServiceOrgCriteria example);

    int updateByPrimaryKeySelective(TbServiceOrg record);

    int updateByPrimaryKey(TbServiceOrg record);
}
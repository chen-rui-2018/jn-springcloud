package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTemp;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTempCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceOrgTempMapper {
    long countByExample(TbServiceOrgTempCriteria example);

    int deleteByExample(TbServiceOrgTempCriteria example);

    int deleteByPrimaryKey(String orgId);

    int insert(TbServiceOrgTemp record);

    int insertSelective(TbServiceOrgTemp record);

    List<TbServiceOrgTemp> selectByExample(TbServiceOrgTempCriteria example);

    TbServiceOrgTemp selectByPrimaryKey(String orgId);

    int updateByExampleSelective(@Param("record") TbServiceOrgTemp record, @Param("example") TbServiceOrgTempCriteria example);

    int updateByExample(@Param("record") TbServiceOrgTemp record, @Param("example") TbServiceOrgTempCriteria example);

    int updateByPrimaryKeySelective(TbServiceOrgTemp record);

    int updateByPrimaryKey(TbServiceOrgTemp record);
}
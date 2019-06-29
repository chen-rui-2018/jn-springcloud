package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgElementTemp;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgElementTempCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceOrgElementTempMapper {
    long countByExample(TbServiceOrgElementTempCriteria example);

    int deleteByExample(TbServiceOrgElementTempCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceOrgElementTemp record);

    int insertSelective(TbServiceOrgElementTemp record);

    List<TbServiceOrgElementTemp> selectByExample(TbServiceOrgElementTempCriteria example);

    TbServiceOrgElementTemp selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceOrgElementTemp record, @Param("example") TbServiceOrgElementTempCriteria example);

    int updateByExample(@Param("record") TbServiceOrgElementTemp record, @Param("example") TbServiceOrgElementTempCriteria example);

    int updateByPrimaryKeySelective(TbServiceOrgElementTemp record);

    int updateByPrimaryKey(TbServiceOrgElementTemp record);
}
package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTraitTemp;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTraitTempCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceOrgTraitTempMapper {
    long countByExample(TbServiceOrgTraitTempCriteria example);

    int deleteByExample(TbServiceOrgTraitTempCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceOrgTraitTemp record);

    int insertSelective(TbServiceOrgTraitTemp record);

    List<TbServiceOrgTraitTemp> selectByExample(TbServiceOrgTraitTempCriteria example);

    TbServiceOrgTraitTemp selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceOrgTraitTemp record, @Param("example") TbServiceOrgTraitTempCriteria example);

    int updateByExample(@Param("record") TbServiceOrgTraitTemp record, @Param("example") TbServiceOrgTraitTempCriteria example);

    int updateByPrimaryKeySelective(TbServiceOrgTraitTemp record);

    int updateByPrimaryKey(TbServiceOrgTraitTemp record);
}
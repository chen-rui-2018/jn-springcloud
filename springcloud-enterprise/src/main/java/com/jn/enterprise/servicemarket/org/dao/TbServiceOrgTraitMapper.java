package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTrait;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTraitCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceOrgTraitMapper {
    long countByExample(TbServiceOrgTraitCriteria example);

    int deleteByExample(TbServiceOrgTraitCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceOrgTrait record);

    int insertSelective(TbServiceOrgTrait record);

    List<TbServiceOrgTrait> selectByExample(TbServiceOrgTraitCriteria example);

    TbServiceOrgTrait selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceOrgTrait record, @Param("example") TbServiceOrgTraitCriteria example);

    int updateByExample(@Param("record") TbServiceOrgTrait record, @Param("example") TbServiceOrgTraitCriteria example);

    int updateByPrimaryKeySelective(TbServiceOrgTrait record);

    int updateByPrimaryKey(TbServiceOrgTrait record);
}
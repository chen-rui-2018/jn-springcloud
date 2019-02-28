package com.jn.enterprise.servicemarket.industryarea.dao;

import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePrefer;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePreferCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServicePreferMapper {
    long countByExample(TbServicePreferCriteria example);

    int deleteByExample(TbServicePreferCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServicePrefer record);

    int insertSelective(TbServicePrefer record);

    List<TbServicePrefer> selectByExample(TbServicePreferCriteria example);

    TbServicePrefer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServicePrefer record, @Param("example") TbServicePreferCriteria example);

    int updateByExample(@Param("record") TbServicePrefer record, @Param("example") TbServicePreferCriteria example);

    int updateByPrimaryKeySelective(TbServicePrefer record);

    int updateByPrimaryKey(TbServicePrefer record);
}
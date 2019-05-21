package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricRulesContent;
import com.jn.park.electricmeter.entity.TbElectricRulesContentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricRulesContentMapper {
    long countByExample(TbElectricRulesContentCriteria example);

    int deleteByExample(TbElectricRulesContentCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricRulesContent record);

    int insertSelective(TbElectricRulesContent record);

    List<TbElectricRulesContent> selectByExample(TbElectricRulesContentCriteria example);

    TbElectricRulesContent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricRulesContent record, @Param("example") TbElectricRulesContentCriteria example);

    int updateByExample(@Param("record") TbElectricRulesContent record, @Param("example") TbElectricRulesContentCriteria example);

    int updateByPrimaryKeySelective(TbElectricRulesContent record);

    int updateByPrimaryKey(TbElectricRulesContent record);
}
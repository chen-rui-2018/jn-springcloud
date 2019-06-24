package com.jn.park.pmpaybill.dao;

import com.jn.park.pmpaybill.entity.TbPmPriceRuleDeatils;
import com.jn.park.pmpaybill.entity.TbPmPriceRuleDeatilsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPmPriceRuleDeatilsMapper {
    long countByExample(TbPmPriceRuleDeatilsCriteria example);

    int deleteByExample(TbPmPriceRuleDeatilsCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPmPriceRuleDeatils record);

    int insertSelective(TbPmPriceRuleDeatils record);

    List<TbPmPriceRuleDeatils> selectByExample(TbPmPriceRuleDeatilsCriteria example);

    TbPmPriceRuleDeatils selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPmPriceRuleDeatils record, @Param("example") TbPmPriceRuleDeatilsCriteria example);

    int updateByExample(@Param("record") TbPmPriceRuleDeatils record, @Param("example") TbPmPriceRuleDeatilsCriteria example);

    int updateByPrimaryKeySelective(TbPmPriceRuleDeatils record);

    int updateByPrimaryKey(TbPmPriceRuleDeatils record);
}
package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricCost;
import com.jn.park.electricmeter.entity.TbElectricCostCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricCostMapper {
    long countByExample(TbElectricCostCriteria example);

    int deleteByExample(TbElectricCostCriteria example);

    int deleteByPrimaryKey(String companyId);

    int insert(TbElectricCost record);

    int insertSelective(TbElectricCost record);

    List<TbElectricCost> selectByExample(TbElectricCostCriteria example);

    TbElectricCost selectByPrimaryKey(String companyId);

    int updateByExampleSelective(@Param("record") TbElectricCost record, @Param("example") TbElectricCostCriteria example);

    int updateByExample(@Param("record") TbElectricCost record, @Param("example") TbElectricCostCriteria example);

    int updateByPrimaryKeySelective(TbElectricCost record);

    int updateByPrimaryKey(TbElectricCost record);
}
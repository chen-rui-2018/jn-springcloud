package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricEnergyBill;
import com.jn.park.electricmeter.entity.TbElectricEnergyBillCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricEnergyBillMapper {
    long countByExample(TbElectricEnergyBillCriteria example);

    int deleteByExample(TbElectricEnergyBillCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricEnergyBill record);

    int insertSelective(TbElectricEnergyBill record);

    List<TbElectricEnergyBill> selectByExample(TbElectricEnergyBillCriteria example);

    TbElectricEnergyBill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricEnergyBill record, @Param("example") TbElectricEnergyBillCriteria example);

    int updateByExample(@Param("record") TbElectricEnergyBill record, @Param("example") TbElectricEnergyBillCriteria example);

    int updateByPrimaryKeySelective(TbElectricEnergyBill record);

    int updateByPrimaryKey(TbElectricEnergyBill record);
}
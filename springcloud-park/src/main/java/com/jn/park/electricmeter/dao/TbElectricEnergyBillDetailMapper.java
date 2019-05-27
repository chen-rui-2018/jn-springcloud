package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricEnergyBillDetail;
import com.jn.park.electricmeter.entity.TbElectricEnergyBillDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricEnergyBillDetailMapper {
    long countByExample(TbElectricEnergyBillDetailCriteria example);

    int deleteByExample(TbElectricEnergyBillDetailCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricEnergyBillDetail record);

    int insertSelective(TbElectricEnergyBillDetail record);

    List<TbElectricEnergyBillDetail> selectByExample(TbElectricEnergyBillDetailCriteria example);

    TbElectricEnergyBillDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricEnergyBillDetail record, @Param("example") TbElectricEnergyBillDetailCriteria example);

    int updateByExample(@Param("record") TbElectricEnergyBillDetail record, @Param("example") TbElectricEnergyBillDetailCriteria example);

    int updateByPrimaryKeySelective(TbElectricEnergyBillDetail record);

    int updateByPrimaryKey(TbElectricEnergyBillDetail record);
}
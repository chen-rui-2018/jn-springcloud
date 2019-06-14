package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.VElectricRulesInfo;
import com.jn.park.electricmeter.entity.VElectricRulesInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VElectricRulesInfoMapper {
    long countByExample(VElectricRulesInfoCriteria example);

    int deleteByExample(VElectricRulesInfoCriteria example);

    int insert(VElectricRulesInfo record);

    int insertSelective(VElectricRulesInfo record);

    List<VElectricRulesInfo> selectByExample(VElectricRulesInfoCriteria example);

    int updateByExampleSelective(@Param("record") VElectricRulesInfo record, @Param("example") VElectricRulesInfoCriteria example);

    int updateByExample(@Param("record") VElectricRulesInfo record, @Param("example") VElectricRulesInfoCriteria example);
}
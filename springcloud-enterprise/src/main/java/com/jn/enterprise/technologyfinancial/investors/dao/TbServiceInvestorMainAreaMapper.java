package com.jn.enterprise.technologyfinancial.investors.dao;

import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorMainArea;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorMainAreaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceInvestorMainAreaMapper {
    long countByExample(TbServiceInvestorMainAreaCriteria example);

    int deleteByExample(TbServiceInvestorMainAreaCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceInvestorMainArea record);

    int insertSelective(TbServiceInvestorMainArea record);

    List<TbServiceInvestorMainArea> selectByExample(TbServiceInvestorMainAreaCriteria example);

    TbServiceInvestorMainArea selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceInvestorMainArea record, @Param("example") TbServiceInvestorMainAreaCriteria example);

    int updateByExample(@Param("record") TbServiceInvestorMainArea record, @Param("example") TbServiceInvestorMainAreaCriteria example);

    int updateByPrimaryKeySelective(TbServiceInvestorMainArea record);

    int updateByPrimaryKey(TbServiceInvestorMainArea record);
}
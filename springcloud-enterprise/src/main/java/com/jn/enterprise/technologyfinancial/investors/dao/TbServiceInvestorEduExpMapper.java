package com.jn.enterprise.technologyfinancial.investors.dao;

import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorEduExp;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorEduExpCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbServiceInvestorEduExpMapper {
    long countByExample(TbServiceInvestorEduExpCriteria example);

    int deleteByExample(TbServiceInvestorEduExpCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceInvestorEduExp record);

    int insertSelective(TbServiceInvestorEduExp record);

    List<TbServiceInvestorEduExp> selectByExample(TbServiceInvestorEduExpCriteria example);

    TbServiceInvestorEduExp selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceInvestorEduExp record, @Param("example") TbServiceInvestorEduExpCriteria example);

    int updateByExample(@Param("record") TbServiceInvestorEduExp record, @Param("example") TbServiceInvestorEduExpCriteria example);

    int updateByPrimaryKeySelective(TbServiceInvestorEduExp record);

    int updateByPrimaryKey(TbServiceInvestorEduExp record);
}
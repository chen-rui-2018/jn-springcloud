package com.jn.enterprise.technologyfinancial.investors.dao;

import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorWorkExp;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorWorkExpCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceInvestorWorkExpMapper {
    long countByExample(TbServiceInvestorWorkExpCriteria example);

    int deleteByExample(TbServiceInvestorWorkExpCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceInvestorWorkExp record);

    int insertSelective(TbServiceInvestorWorkExp record);

    List<TbServiceInvestorWorkExp> selectByExample(TbServiceInvestorWorkExpCriteria example);

    TbServiceInvestorWorkExp selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceInvestorWorkExp record, @Param("example") TbServiceInvestorWorkExpCriteria example);

    int updateByExample(@Param("record") TbServiceInvestorWorkExp record, @Param("example") TbServiceInvestorWorkExpCriteria example);

    int updateByPrimaryKeySelective(TbServiceInvestorWorkExp record);

    int updateByPrimaryKey(TbServiceInvestorWorkExp record);
}
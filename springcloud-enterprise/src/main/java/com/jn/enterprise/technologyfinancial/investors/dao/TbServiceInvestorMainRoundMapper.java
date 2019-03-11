package com.jn.enterprise.technologyfinancial.investors.dao;

import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorMainRound;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorMainRoundCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceInvestorMainRoundMapper {
    long countByExample(TbServiceInvestorMainRoundCriteria example);

    int deleteByExample(TbServiceInvestorMainRoundCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceInvestorMainRound record);

    int insertSelective(TbServiceInvestorMainRound record);

    List<TbServiceInvestorMainRound> selectByExample(TbServiceInvestorMainRoundCriteria example);

    TbServiceInvestorMainRound selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceInvestorMainRound record, @Param("example") TbServiceInvestorMainRoundCriteria example);

    int updateByExample(@Param("record") TbServiceInvestorMainRound record, @Param("example") TbServiceInvestorMainRoundCriteria example);

    int updateByPrimaryKeySelective(TbServiceInvestorMainRound record);

    int updateByPrimaryKey(TbServiceInvestorMainRound record);
}
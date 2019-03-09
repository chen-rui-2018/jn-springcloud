package com.jn.enterprise.technologyfinancial.investors.dao;

import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestor;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceInvestorMapper {
    long countByExample(TbServiceInvestorCriteria example);

    int deleteByExample(TbServiceInvestorCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceInvestor record);

    int insertSelective(TbServiceInvestor record);

    List<TbServiceInvestor> selectByExample(TbServiceInvestorCriteria example);

    TbServiceInvestor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceInvestor record, @Param("example") TbServiceInvestorCriteria example);

    int updateByExample(@Param("record") TbServiceInvestor record, @Param("example") TbServiceInvestorCriteria example);

    int updateByPrimaryKeySelective(TbServiceInvestor record);

    int updateByPrimaryKey(TbServiceInvestor record);
}
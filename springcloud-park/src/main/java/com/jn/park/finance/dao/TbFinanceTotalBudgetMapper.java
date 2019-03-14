package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceTotalBudget;
import com.jn.park.finance.entity.TbFinanceTotalBudgetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceTotalBudgetMapper {
    long countByExample(TbFinanceTotalBudgetExample example);

    int deleteByExample(TbFinanceTotalBudgetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFinanceTotalBudget record);

    int insertSelective(TbFinanceTotalBudget record);

    List<TbFinanceTotalBudget> selectByExample(TbFinanceTotalBudgetExample example);

    TbFinanceTotalBudget selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFinanceTotalBudget record, @Param("example") TbFinanceTotalBudgetExample example);

    int updateByExample(@Param("record") TbFinanceTotalBudget record, @Param("example") TbFinanceTotalBudgetExample example);

    int updateByPrimaryKeySelective(TbFinanceTotalBudget record);

    int updateByPrimaryKey(TbFinanceTotalBudget record);
}
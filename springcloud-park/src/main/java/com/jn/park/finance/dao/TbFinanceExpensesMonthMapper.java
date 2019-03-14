package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceExpensesMonth;
import com.jn.park.finance.entity.TbFinanceExpensesMonthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceExpensesMonthMapper {
    long countByExample(TbFinanceExpensesMonthExample example);

    int deleteByExample(TbFinanceExpensesMonthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFinanceExpensesMonth record);

    int insertSelective(TbFinanceExpensesMonth record);

    List<TbFinanceExpensesMonth> selectByExample(TbFinanceExpensesMonthExample example);

    TbFinanceExpensesMonth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFinanceExpensesMonth record, @Param("example") TbFinanceExpensesMonthExample example);

    int updateByExample(@Param("record") TbFinanceExpensesMonth record, @Param("example") TbFinanceExpensesMonthExample example);

    int updateByPrimaryKeySelective(TbFinanceExpensesMonth record);

    int updateByPrimaryKey(TbFinanceExpensesMonth record);
}
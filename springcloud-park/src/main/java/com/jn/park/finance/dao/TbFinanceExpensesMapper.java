package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceExpenses;
import com.jn.park.finance.entity.TbFinanceExpensesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceExpensesMapper {
    long countByExample(TbFinanceExpensesExample example);

    int deleteByExample(TbFinanceExpensesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFinanceExpenses record);

    int insertSelective(TbFinanceExpenses record);

    List<TbFinanceExpenses> selectByExample(TbFinanceExpensesExample example);

    TbFinanceExpenses selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFinanceExpenses record, @Param("example") TbFinanceExpensesExample example);

    int updateByExample(@Param("record") TbFinanceExpenses record, @Param("example") TbFinanceExpensesExample example);

    int updateByPrimaryKeySelective(TbFinanceExpenses record);

    int updateByPrimaryKey(TbFinanceExpenses record);
}
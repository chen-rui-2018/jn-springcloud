package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceExpensesTemp;
import com.jn.park.finance.entity.TbFinanceExpensesTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceExpensesTempMapper {
    long countByExample(TbFinanceExpensesTempExample example);

    int deleteByExample(TbFinanceExpensesTempExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFinanceExpensesTemp record);

    int insertSelective(TbFinanceExpensesTemp record);

    List<TbFinanceExpensesTemp> selectByExample(TbFinanceExpensesTempExample example);

    TbFinanceExpensesTemp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFinanceExpensesTemp record, @Param("example") TbFinanceExpensesTempExample example);

    int updateByExample(@Param("record") TbFinanceExpensesTemp record, @Param("example") TbFinanceExpensesTempExample example);

    int updateByPrimaryKeySelective(TbFinanceExpensesTemp record);

    int updateByPrimaryKey(TbFinanceExpensesTemp record);
}
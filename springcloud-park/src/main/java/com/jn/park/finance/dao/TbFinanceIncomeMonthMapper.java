package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceIncomeMonth;
import com.jn.park.finance.entity.TbFinanceIncomeMonthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceIncomeMonthMapper {
    long countByExample(TbFinanceIncomeMonthExample example);

    int deleteByExample(TbFinanceIncomeMonthExample example);

    int insert(TbFinanceIncomeMonth record);

    int insertSelective(TbFinanceIncomeMonth record);

    List<TbFinanceIncomeMonth> selectByExample(TbFinanceIncomeMonthExample example);

    int updateByExampleSelective(@Param("record") TbFinanceIncomeMonth record, @Param("example") TbFinanceIncomeMonthExample example);

    int updateByExample(@Param("record") TbFinanceIncomeMonth record, @Param("example") TbFinanceIncomeMonthExample example);
}
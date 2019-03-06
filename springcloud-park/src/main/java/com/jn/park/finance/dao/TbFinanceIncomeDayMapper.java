package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceIncomeDay;
import com.jn.park.finance.entity.TbFinanceIncomeDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceIncomeDayMapper {
    long countByExample(TbFinanceIncomeDayExample example);

    int deleteByExample(TbFinanceIncomeDayExample example);

    int insert(TbFinanceIncomeDay record);

    int insertSelective(TbFinanceIncomeDay record);

    List<TbFinanceIncomeDay> selectByExample(TbFinanceIncomeDayExample example);

    int updateByExampleSelective(@Param("record") TbFinanceIncomeDay record, @Param("example") TbFinanceIncomeDayExample example);

    int updateByExample(@Param("record") TbFinanceIncomeDay record, @Param("example") TbFinanceIncomeDayExample example);
}
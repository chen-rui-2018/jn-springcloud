package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceIncomeDay;
import com.jn.park.finance.entity.TbFinanceIncomeDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceIncomeDayMapper {
    long countByExample(TbFinanceIncomeDayExample example);

    int deleteByExample(TbFinanceIncomeDayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFinanceIncomeDay record);

    int insertSelective(TbFinanceIncomeDay record);

    List<TbFinanceIncomeDay> selectByExample(TbFinanceIncomeDayExample example);

    TbFinanceIncomeDay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFinanceIncomeDay record, @Param("example") TbFinanceIncomeDayExample example);

    int updateByExample(@Param("record") TbFinanceIncomeDay record, @Param("example") TbFinanceIncomeDayExample example);

    int updateByPrimaryKeySelective(TbFinanceIncomeDay record);

    int updateByPrimaryKey(TbFinanceIncomeDay record);
}
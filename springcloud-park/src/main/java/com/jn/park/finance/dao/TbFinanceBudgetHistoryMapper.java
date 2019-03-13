package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceBudgetHistory;
import com.jn.park.finance.entity.TbFinanceBudgetHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceBudgetHistoryMapper {
    long countByExample(TbFinanceBudgetHistoryExample example);

    int deleteByExample(TbFinanceBudgetHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFinanceBudgetHistory record);

    int insertSelective(TbFinanceBudgetHistory record);

    List<TbFinanceBudgetHistory> selectByExample(TbFinanceBudgetHistoryExample example);

    TbFinanceBudgetHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFinanceBudgetHistory record, @Param("example") TbFinanceBudgetHistoryExample example);

    int updateByExample(@Param("record") TbFinanceBudgetHistory record, @Param("example") TbFinanceBudgetHistoryExample example);

    int updateByPrimaryKeySelective(TbFinanceBudgetHistory record);

    int updateByPrimaryKey(TbFinanceBudgetHistory record);
}
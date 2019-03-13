package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbMonth;
import com.jn.park.finance.entity.TbMonthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMonthMapper {
    long countByExample(TbMonthExample example);

    int deleteByExample(TbMonthExample example);

    int deleteByPrimaryKey(String month);

    int insert(TbMonth record);

    int insertSelective(TbMonth record);

    List<TbMonth> selectByExample(TbMonthExample example);

    int updateByExampleSelective(@Param("record") TbMonth record, @Param("example") TbMonthExample example);

    int updateByExample(@Param("record") TbMonth record, @Param("example") TbMonthExample example);
}
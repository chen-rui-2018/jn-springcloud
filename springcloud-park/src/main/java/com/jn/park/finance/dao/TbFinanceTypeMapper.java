package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceType;
import com.jn.park.finance.entity.TbFinanceTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceTypeMapper {
    long countByExample(TbFinanceTypeExample example);

    int deleteByExample(TbFinanceTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFinanceType record);

    int insertSelective(TbFinanceType record);

    List<TbFinanceType> selectByExample(TbFinanceTypeExample example);

    TbFinanceType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFinanceType record, @Param("example") TbFinanceTypeExample example);

    int updateByExample(@Param("record") TbFinanceType record, @Param("example") TbFinanceTypeExample example);

    int updateByPrimaryKeySelective(TbFinanceType record);

    int updateByPrimaryKey(TbFinanceType record);
}
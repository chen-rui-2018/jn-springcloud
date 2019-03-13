package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceWorkOrder;
import com.jn.park.finance.entity.TbFinanceWorkOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceWorkOrderMapper {
    long countByExample(TbFinanceWorkOrderExample example);

    int deleteByExample(TbFinanceWorkOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFinanceWorkOrder record);

    int insertSelective(TbFinanceWorkOrder record);

    List<TbFinanceWorkOrder> selectByExample(TbFinanceWorkOrderExample example);

    TbFinanceWorkOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFinanceWorkOrder record, @Param("example") TbFinanceWorkOrderExample example);

    int updateByExample(@Param("record") TbFinanceWorkOrder record, @Param("example") TbFinanceWorkOrderExample example);

    int updateByPrimaryKeySelective(TbFinanceWorkOrder record);

    int updateByPrimaryKey(TbFinanceWorkOrder record);
}
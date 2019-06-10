package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceDepartmentToType;
import com.jn.park.finance.entity.TbFinanceDepartmentToTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceDepartmentToTypeMapper {
    long countByExample(TbFinanceDepartmentToTypeExample example);

    int deleteByExample(TbFinanceDepartmentToTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbFinanceDepartmentToType record);

    int insertSelective(TbFinanceDepartmentToType record);

    List<TbFinanceDepartmentToType> selectByExample(TbFinanceDepartmentToTypeExample example);

    TbFinanceDepartmentToType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbFinanceDepartmentToType record, @Param("example") TbFinanceDepartmentToTypeExample example);

    int updateByExample(@Param("record") TbFinanceDepartmentToType record, @Param("example") TbFinanceDepartmentToTypeExample example);

    int updateByPrimaryKeySelective(TbFinanceDepartmentToType record);

    int updateByPrimaryKey(TbFinanceDepartmentToType record);
}
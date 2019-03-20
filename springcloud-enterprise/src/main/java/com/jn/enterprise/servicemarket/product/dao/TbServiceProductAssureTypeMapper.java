package com.jn.enterprise.servicemarket.product.dao;

import com.jn.enterprise.servicemarket.product.entity.TbServiceProductAssureType;
import com.jn.enterprise.servicemarket.product.entity.TbServiceProductAssureTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceProductAssureTypeMapper {
    long countByExample(TbServiceProductAssureTypeCriteria example);

    int deleteByExample(TbServiceProductAssureTypeCriteria example);

    int deleteByPrimaryKey(String assureCode);

    int insert(TbServiceProductAssureType record);

    int insertSelective(TbServiceProductAssureType record);

    List<TbServiceProductAssureType> selectByExample(TbServiceProductAssureTypeCriteria example);

    TbServiceProductAssureType selectByPrimaryKey(String assureCode);

    int updateByExampleSelective(@Param("record") TbServiceProductAssureType record, @Param("example") TbServiceProductAssureTypeCriteria example);

    int updateByExample(@Param("record") TbServiceProductAssureType record, @Param("example") TbServiceProductAssureTypeCriteria example);

    int updateByPrimaryKeySelective(TbServiceProductAssureType record);

    int updateByPrimaryKey(TbServiceProductAssureType record);
}
package com.jn.activity.dao;

import com.jn.activity.entity.TbActivityType;
import com.jn.activity.entity.TbActivityTypeCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbActivityTypeMapper {
    long countByExample(TbActivityTypeCriteria example);

    int deleteByExample(TbActivityTypeCriteria example);

    int deleteByPrimaryKey(String typeId);

    int insert(TbActivityType record);

    int insertSelective(TbActivityType record);

    List<TbActivityType> selectByExample(TbActivityTypeCriteria example);

    TbActivityType selectByPrimaryKey(String typeId);

    int updateByExampleSelective(@Param("record") TbActivityType record, @Param("example") TbActivityTypeCriteria example);

    int updateByExample(@Param("record") TbActivityType record, @Param("example") TbActivityTypeCriteria example);

    int updateByPrimaryKeySelective(TbActivityType record);

    int updateByPrimaryKey(TbActivityType record);
}
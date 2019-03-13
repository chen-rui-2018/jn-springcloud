package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceDictionary;
import com.jn.park.finance.entity.TbFinanceDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceDictionaryMapper {
    long countByExample(TbFinanceDictionaryExample example);

    int deleteByExample(TbFinanceDictionaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFinanceDictionary record);

    int insertSelective(TbFinanceDictionary record);

    List<TbFinanceDictionary> selectByExample(TbFinanceDictionaryExample example);

    TbFinanceDictionary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFinanceDictionary record, @Param("example") TbFinanceDictionaryExample example);

    int updateByExample(@Param("record") TbFinanceDictionary record, @Param("example") TbFinanceDictionaryExample example);

    int updateByPrimaryKeySelective(TbFinanceDictionary record);

    int updateByPrimaryKey(TbFinanceDictionary record);
}
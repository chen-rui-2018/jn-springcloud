package com.jn.enterprise.common.dao;

import com.jn.enterprise.common.entity.TbServiceCode;
import com.jn.enterprise.common.entity.TbServiceCodeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceCodeMapper {
    long countByExample(TbServiceCodeCriteria example);

    int deleteByExample(TbServiceCodeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceCode record);

    int insertSelective(TbServiceCode record);

    List<TbServiceCode> selectByExample(TbServiceCodeCriteria example);

    TbServiceCode selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceCode record, @Param("example") TbServiceCodeCriteria example);

    int updateByExample(@Param("record") TbServiceCode record, @Param("example") TbServiceCodeCriteria example);

    int updateByPrimaryKeySelective(TbServiceCode record);

    int updateByPrimaryKey(TbServiceCode record);
}
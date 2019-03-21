package com.jn.enterprise.servicemarket.require.dao;

import com.jn.enterprise.servicemarket.require.entity.TbServiceRequire;
import com.jn.enterprise.servicemarket.require.entity.TbServiceRequireCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceRequireMapper {
    long countByExample(TbServiceRequireCriteria example);

    int deleteByExample(TbServiceRequireCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceRequire record);

    int insertSelective(TbServiceRequire record);

    List<TbServiceRequire> selectByExample(TbServiceRequireCriteria example);

    TbServiceRequire selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceRequire record, @Param("example") TbServiceRequireCriteria example);

    int updateByExample(@Param("record") TbServiceRequire record, @Param("example") TbServiceRequireCriteria example);

    int updateByPrimaryKeySelective(TbServiceRequire record);

    int updateByPrimaryKey(TbServiceRequire record);
}
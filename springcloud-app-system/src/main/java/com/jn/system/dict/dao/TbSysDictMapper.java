package com.jn.system.dict.dao;

import com.jn.system.dict.entity.TbSysDict;
import com.jn.system.dict.entity.TbSysDictCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysDictMapper {
    long countByExample(TbSysDictCriteria example);

    int deleteByExample(TbSysDictCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysDict record);

    int insertSelective(TbSysDict record);

    List<TbSysDict> selectByExample(TbSysDictCriteria example);

    TbSysDict selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysDict record, @Param("example") TbSysDictCriteria example);

    int updateByExample(@Param("record") TbSysDict record, @Param("example") TbSysDictCriteria example);

    int updateByPrimaryKeySelective(TbSysDict record);

    int updateByPrimaryKey(TbSysDict record);
}
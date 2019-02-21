package com.jn.system.dict.dao;

import com.jn.system.dict.entity.TbSysDictModule;
import com.jn.system.dict.entity.TbSysDictModuleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysDictModuleMapper {
    long countByExample(TbSysDictModuleCriteria example);

    int deleteByExample(TbSysDictModuleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysDictModule record);

    int insertSelective(TbSysDictModule record);

    List<TbSysDictModule> selectByExample(TbSysDictModuleCriteria example);

    TbSysDictModule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysDictModule record, @Param("example") TbSysDictModuleCriteria example);

    int updateByExample(@Param("record") TbSysDictModule record, @Param("example") TbSysDictModuleCriteria example);

    int updateByPrimaryKeySelective(TbSysDictModule record);

    int updateByPrimaryKey(TbSysDictModule record);
}
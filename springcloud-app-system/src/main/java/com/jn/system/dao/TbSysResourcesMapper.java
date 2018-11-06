package com.jn.system.dao;

import com.jn.system.entity.TbSysResources;
import com.jn.system.entity.TbSysResourcesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysResourcesMapper {
    long countByExample(TbSysResourcesCriteria example);

    int deleteByExample(TbSysResourcesCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysResources record);

    int insertSelective(TbSysResources record);

    List<TbSysResources> selectByExample(TbSysResourcesCriteria example);

    TbSysResources selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysResources record, @Param("example") TbSysResourcesCriteria example);

    int updateByExample(@Param("record") TbSysResources record, @Param("example") TbSysResourcesCriteria example);

    int updateByPrimaryKeySelective(TbSysResources record);

    int updateByPrimaryKey(TbSysResources record);
}
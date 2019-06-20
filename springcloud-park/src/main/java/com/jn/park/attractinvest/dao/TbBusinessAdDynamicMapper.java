package com.jn.park.attractinvest.dao;

import com.jn.park.attractinvest.entity.TbBusinessAdDynamic;
import com.jn.park.attractinvest.entity.TbBusinessAdDynamicCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbBusinessAdDynamicMapper {
    long countByExample(TbBusinessAdDynamicCriteria example);

    int deleteByExample(TbBusinessAdDynamicCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbBusinessAdDynamic record);

    int insertSelective(TbBusinessAdDynamic record);

    List<TbBusinessAdDynamic> selectByExampleWithBLOBs(TbBusinessAdDynamicCriteria example);

    List<TbBusinessAdDynamic> selectByExample(TbBusinessAdDynamicCriteria example);

    TbBusinessAdDynamic selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbBusinessAdDynamic record, @Param("example") TbBusinessAdDynamicCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbBusinessAdDynamic record, @Param("example") TbBusinessAdDynamicCriteria example);

    int updateByExample(@Param("record") TbBusinessAdDynamic record, @Param("example") TbBusinessAdDynamicCriteria example);

    int updateByPrimaryKeySelective(TbBusinessAdDynamic record);

    int updateByPrimaryKeyWithBLOBs(TbBusinessAdDynamic record);

    int updateByPrimaryKey(TbBusinessAdDynamic record);
}
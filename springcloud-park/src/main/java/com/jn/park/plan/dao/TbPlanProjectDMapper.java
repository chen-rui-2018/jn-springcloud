package com.jn.park.plan.dao;

import com.jn.park.plan.entity.TbPlanProjectD;
import com.jn.park.plan.entity.TbPlanProjectDCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPlanProjectDMapper {
    long countByExample(TbPlanProjectDCriteria example);

    int deleteByExample(TbPlanProjectDCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPlanProjectD record);

    int insertSelective(TbPlanProjectD record);

    List<TbPlanProjectD> selectByExample(TbPlanProjectDCriteria example);

    TbPlanProjectD selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPlanProjectD record, @Param("example") TbPlanProjectDCriteria example);

    int updateByExample(@Param("record") TbPlanProjectD record, @Param("example") TbPlanProjectDCriteria example);

    int updateByPrimaryKeySelective(TbPlanProjectD record);

    int updateByPrimaryKey(TbPlanProjectD record);
}
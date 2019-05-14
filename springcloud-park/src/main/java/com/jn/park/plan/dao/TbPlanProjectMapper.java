package com.jn.park.plan.dao;

import com.jn.park.plan.entity.TbPlanProject;
import com.jn.park.plan.entity.TbPlanProjectCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPlanProjectMapper {
    long countByExample(TbPlanProjectCriteria example);

    int deleteByExample(TbPlanProjectCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPlanProject record);

    int insertSelective(TbPlanProject record);

    List<TbPlanProject> selectByExample(TbPlanProjectCriteria example);

    TbPlanProject selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPlanProject record, @Param("example") TbPlanProjectCriteria example);

    int updateByExample(@Param("record") TbPlanProject record, @Param("example") TbPlanProjectCriteria example);

    int updateByPrimaryKeySelective(TbPlanProject record);

    int updateByPrimaryKey(TbPlanProject record);
}
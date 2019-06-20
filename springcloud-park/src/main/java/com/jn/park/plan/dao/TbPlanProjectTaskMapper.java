package com.jn.park.plan.dao;

import com.jn.park.plan.entity.TbPlanProjectTask;
import com.jn.park.plan.entity.TbPlanProjectTaskCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPlanProjectTaskMapper {
    long countByExample(TbPlanProjectTaskCriteria example);

    int deleteByExample(TbPlanProjectTaskCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPlanProjectTask record);

    int insertSelective(TbPlanProjectTask record);

    List<TbPlanProjectTask> selectByExample(TbPlanProjectTaskCriteria example);

    TbPlanProjectTask selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPlanProjectTask record, @Param("example") TbPlanProjectTaskCriteria example);

    int updateByExample(@Param("record") TbPlanProjectTask record, @Param("example") TbPlanProjectTaskCriteria example);

    int updateByPrimaryKeySelective(TbPlanProjectTask record);

    int updateByPrimaryKey(TbPlanProjectTask record);
}
package com.jn.park.plan.dao;

import com.jn.park.plan.entity.TbPlanProjectTaskProcess;
import com.jn.park.plan.entity.TbPlanProjectTaskProcessCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPlanProjectTaskProcessMapper {
    long countByExample(TbPlanProjectTaskProcessCriteria example);

    int deleteByExample(TbPlanProjectTaskProcessCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPlanProjectTaskProcess record);

    int insertSelective(TbPlanProjectTaskProcess record);

    List<TbPlanProjectTaskProcess> selectByExample(TbPlanProjectTaskProcessCriteria example);

    TbPlanProjectTaskProcess selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPlanProjectTaskProcess record, @Param("example") TbPlanProjectTaskProcessCriteria example);

    int updateByExample(@Param("record") TbPlanProjectTaskProcess record, @Param("example") TbPlanProjectTaskProcessCriteria example);

    int updateByPrimaryKeySelective(TbPlanProjectTaskProcess record);

    int updateByPrimaryKey(TbPlanProjectTaskProcess record);
}
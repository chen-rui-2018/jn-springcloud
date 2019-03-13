package com.jn.oa.item.dao;

import com.jn.oa.item.entity.TbOaWorkPlan;
import com.jn.oa.item.entity.TbOaWorkPlanCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaWorkPlanMapper {
    long countByExample(TbOaWorkPlanCriteria example);

    int deleteByExample(TbOaWorkPlanCriteria example);

    int insert(TbOaWorkPlan record);

    int insertSelective(TbOaWorkPlan record);

    List<TbOaWorkPlan> selectByExample(TbOaWorkPlanCriteria example);

    int updateByExampleSelective(@Param("record") TbOaWorkPlan record, @Param("example") TbOaWorkPlanCriteria example);

    int updateByExample(@Param("record") TbOaWorkPlan record, @Param("example") TbOaWorkPlanCriteria example);
}
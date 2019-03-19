package com.jn.oa.item.dao;

import com.jn.oa.item.entity.TbOaWorkPlanHistory;
import com.jn.oa.item.entity.TbOaWorkPlanHistoryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaWorkPlanHistoryMapper {
    long countByExample(TbOaWorkPlanHistoryCriteria example);

    int deleteByExample(TbOaWorkPlanHistoryCriteria example);

    int insert(TbOaWorkPlanHistory record);

    int insertSelective(TbOaWorkPlanHistory record);

    List<TbOaWorkPlanHistory> selectByExample(TbOaWorkPlanHistoryCriteria example);

    int updateByExampleSelective(@Param("record") TbOaWorkPlanHistory record, @Param("example") TbOaWorkPlanHistoryCriteria example);

    int updateByExample(@Param("record") TbOaWorkPlanHistory record, @Param("example") TbOaWorkPlanHistoryCriteria example);
}
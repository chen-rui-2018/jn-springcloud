package com.jn.oa.item.dao;

import com.jn.oa.item.entity.TbOaWorkPlanUser;
import com.jn.oa.item.entity.TbOaWorkPlanUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaWorkPlanUserMapper {
    long countByExample(TbOaWorkPlanUserCriteria example);

    int deleteByExample(TbOaWorkPlanUserCriteria example);

    int insert(TbOaWorkPlanUser record);

    int insertSelective(TbOaWorkPlanUser record);

    List<TbOaWorkPlanUser> selectByExample(TbOaWorkPlanUserCriteria example);

    int updateByExampleSelective(@Param("record") TbOaWorkPlanUser record, @Param("example") TbOaWorkPlanUserCriteria example);

    int updateByExample(@Param("record") TbOaWorkPlanUser record, @Param("example") TbOaWorkPlanUserCriteria example);
}
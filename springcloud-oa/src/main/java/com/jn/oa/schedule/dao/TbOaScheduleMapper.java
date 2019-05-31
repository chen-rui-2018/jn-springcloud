package com.jn.oa.schedule.dao;

import com.jn.oa.schedule.entity.TbOaSchedule;
import com.jn.oa.schedule.entity.TbOaScheduleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOaScheduleMapper {
    long countByExample(TbOaScheduleCriteria example);

    int deleteByExample(TbOaScheduleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbOaSchedule record);

    int insertSelective(TbOaSchedule record);

    List<TbOaSchedule> selectByExample(TbOaScheduleCriteria example);

    TbOaSchedule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOaSchedule record, @Param("example") TbOaScheduleCriteria example);

    int updateByExample(@Param("record") TbOaSchedule record, @Param("example") TbOaScheduleCriteria example);

    int updateByPrimaryKeySelective(TbOaSchedule record);

    int updateByPrimaryKey(TbOaSchedule record);
}
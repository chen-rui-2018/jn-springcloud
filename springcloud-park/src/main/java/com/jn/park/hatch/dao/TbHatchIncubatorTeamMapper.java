package com.jn.park.hatch.dao;

import com.jn.park.hatch.entity.TbHatchIncubatorTeam;
import com.jn.park.hatch.entity.TbHatchIncubatorTeamCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbHatchIncubatorTeamMapper {
    long countByExample(TbHatchIncubatorTeamCriteria example);

    int deleteByExample(TbHatchIncubatorTeamCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbHatchIncubatorTeam record);

    int insertSelective(TbHatchIncubatorTeam record);

    List<TbHatchIncubatorTeam> selectByExample(TbHatchIncubatorTeamCriteria example);

    TbHatchIncubatorTeam selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbHatchIncubatorTeam record, @Param("example") TbHatchIncubatorTeamCriteria example);

    int updateByExample(@Param("record") TbHatchIncubatorTeam record, @Param("example") TbHatchIncubatorTeamCriteria example);

    int updateByPrimaryKeySelective(TbHatchIncubatorTeam record);

    int updateByPrimaryKey(TbHatchIncubatorTeam record);
}
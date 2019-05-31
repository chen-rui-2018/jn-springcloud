package com.jn.park.hatch.dao;

import com.jn.park.hatch.entity.TbHatchIncubatorEnterpriseAndTeam;
import com.jn.park.hatch.entity.TbHatchIncubatorEnterpriseAndTeamCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbHatchIncubatorEnterpriseAndTeamMapper {
    long countByExample(TbHatchIncubatorEnterpriseAndTeamCriteria example);

    int deleteByExample(TbHatchIncubatorEnterpriseAndTeamCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbHatchIncubatorEnterpriseAndTeam record);

    int insertSelective(TbHatchIncubatorEnterpriseAndTeam record);

    List<TbHatchIncubatorEnterpriseAndTeam> selectByExample(TbHatchIncubatorEnterpriseAndTeamCriteria example);

    TbHatchIncubatorEnterpriseAndTeam selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbHatchIncubatorEnterpriseAndTeam record, @Param("example") TbHatchIncubatorEnterpriseAndTeamCriteria example);

    int updateByExample(@Param("record") TbHatchIncubatorEnterpriseAndTeam record, @Param("example") TbHatchIncubatorEnterpriseAndTeamCriteria example);

    int updateByPrimaryKeySelective(TbHatchIncubatorEnterpriseAndTeam record);

    int updateByPrimaryKey(TbHatchIncubatorEnterpriseAndTeam record);
}
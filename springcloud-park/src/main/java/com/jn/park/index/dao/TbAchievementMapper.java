package com.jn.park.index.dao;

import com.jn.park.index.entity.TbAchievement;
import com.jn.park.index.entity.TbAchievementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAchievementMapper {
    long countByExample(TbAchievementCriteria example);

    int deleteByExample(TbAchievementCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbAchievement record);

    int insertSelective(TbAchievement record);

    List<TbAchievement> selectByExample(TbAchievementCriteria example);

    TbAchievement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbAchievement record, @Param("example") TbAchievementCriteria example);

    int updateByExample(@Param("record") TbAchievement record, @Param("example") TbAchievementCriteria example);

    int updateByPrimaryKeySelective(TbAchievement record);

    int updateByPrimaryKey(TbAchievement record);
}